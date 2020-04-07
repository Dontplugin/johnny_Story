package top.sinfulxx.stateMachine.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;
import top.sinfulxx.stateMachine.OrderStatus;
import top.sinfulxx.stateMachine.OrderStatusChangeEvent;
import top.sinfulxx.stateMachine.config.StateMachineConfig;
import top.sinfulxx.stateMachine.entity.Order;

/**
 * @author hanyuzhe
 * @date 2020/4/7 11:31 上午
 * @since 1.0
 */
@Slf4j
@Component("orderStateListener")
@WithStateMachine(id = StateMachineConfig.orderStateMachineId)
public class OrderStateListenerImpl{

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_DELIVER);
        log.info("[状态监听] 支付 headers={}",  message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.WAIT_RECEIVE);
        log.info("[状态监听] 发货 headers={}",  message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message<OrderStatusChangeEvent> message){
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderStatus.FINISH);
        log.info("[状态监听] 收货 headers={}",  message.getHeaders().toString());
        return true;
    }
}
