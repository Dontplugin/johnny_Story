package top.sinfulxx.stateMachine.service;

import top.sinfulxx.stateMachine.entity.Order;

import java.util.Map;

/**
 * @author hanyuzhe
 * @date 2020/4/7 11:33 上午
 * @since 1.0
 */
public interface OrderService {
    Order creat();

    Order pay(int id);

    Order deliver(int id);

    Order receive(int id);

    Map<Integer, Order> getOrders();
}
