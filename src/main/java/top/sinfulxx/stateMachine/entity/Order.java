package top.sinfulxx.stateMachine.entity;

import lombok.Data;
import top.sinfulxx.stateMachine.OrderStatus;

/**
 * @author hanyuzhe
 * @date 2020/4/7 11:10 上午
 * @since 1.0
 */
@Data
public class Order {
    private Integer id;
    private OrderStatus status;
}
