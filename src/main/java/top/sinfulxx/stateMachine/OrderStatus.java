package top.sinfulxx.stateMachine;

/**
 * @author hanyuzhe
 * @date 2020/4/6 11:40 下午
 * @since 1.0
 */
public enum OrderStatus {
    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;
}
