package top.sinfulxx.stateMachine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;
import top.sinfulxx.stateMachine.OrderStatus;
import top.sinfulxx.stateMachine.OrderStatusChangeEvent;
import top.sinfulxx.stateMachine.entity.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanyuzhe
 * @date 2020/4/7 11:33 上午
 * @since 1.0
 */
@Slf4j
@Service("orderService")
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;

    @Autowired
    private StateMachineFactory<OrderStatus, OrderStatusChangeEvent> orderStateMachineFactory;
    @Autowired
    private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;

    public static final String stateMachineId = "orderStateMachine";
    private int id = 1;
    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order creat() {
        Order order = new Order();
        order.setStatus(OrderStatus.WAIT_PAYMENT);
        order.setId(id++);
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Order pay(int id) {
        Order order = orders.get(id);
        log.info("[转态流转] threadName={},  尝试支付 id={}", Thread.currentThread().getName(), id);
        Message message = MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build();
        if (!sendEvent(message, order)) {
            log.info("[转态流转] threadName={},  支付失败, 状态异常 id={}", Thread.currentThread().getName(), id);
        }
        return orders.get(id);
    }

    @Override
    public Order deliver(int id) {
        Order order = orders.get(id);
        log.info("[转态流转] threadName={},  尝试发货 id={}", Thread.currentThread().getName(), id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build(), orders.get(id))) {
            log.info("[转态流转] threadName={},  发货失败，状态异常 id={}", Thread.currentThread().getName(), id);
        }
        return orders.get(id);
    }

    @Override
    public Order receive(int id) {
        Order order = orders.get(id);
        log.info("[转态流转] threadName={},  尝试收货 id={}", Thread.currentThread().getName(), id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build(), orders.get(id))) {
            log.info("[转态流转] threadName={},  收货失败，状态异常 id={}", Thread.currentThread().getName(), id);
        }
        return orders.get(id);
    }

    @Override
    public Map<Integer, Order> getOrders() {
        return orders;
    }

    /**
     * 发送订单状态转换事件
     *
     * @param message
     * @param order
     * @return
     */
    private synchronized boolean sendEvent(Message<OrderStatusChangeEvent> message, Order order) {

        synchronized (String.valueOf(order.getId()).intern()) {
            boolean result = false;
            StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine = orderStateMachineFactory.getStateMachine(stateMachineId);
            System.out.println("id=" + order.getId() + " 状态机 orderStateMachine" + orderStateMachine);
            try {
                orderStateMachine.start();
                //尝试恢复状态机状态
                persister.restore(orderStateMachine, order);
                //添加延迟用于线程安全测试
                Thread.sleep(1000);
                result = orderStateMachine.sendEvent(message);
                //持久化状态机状态
                persister.persist(orderStateMachine, order);
            } catch (Exception e) {
                log.error("状态机流转错误", e);
            } finally {
                orderStateMachine.stop();
            }
            return result;
        }
    }
}
