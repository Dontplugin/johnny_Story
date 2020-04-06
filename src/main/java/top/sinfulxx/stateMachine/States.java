package top.sinfulxx.stateMachine;

/**
 * @author hanyuzhe
 * @date 2020/4/6 11:40 下午
 * @since 1.0
 */
public enum States {
    UNPAID,                 // 待支付
    WAITING_FOR_RECEIVE,    // 待收货
    DONE                    // 结束
}
