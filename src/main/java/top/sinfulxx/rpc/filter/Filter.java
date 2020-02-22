package top.sinfulxx.rpc.filter;

import top.sinfulxx.rpc.entity.Request;
import top.sinfulxx.rpc.entity.Response;
import top.sinfulxx.rpc.invoker.Invoker;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:38 下午
 * @since 1.0
 */
public interface Filter {

    Object filter(Request request, Invoker invoker);
}
