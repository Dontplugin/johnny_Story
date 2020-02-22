package top.sinfulxx.rpc.invoker;

import top.sinfulxx.rpc.entity.Request;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:03 下午
 * @since 1.0
 */
public interface Invoker {

    Object invoke(Request request);
}
