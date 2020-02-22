package top.sinfulxx.rpc;

import top.sinfulxx.rpc.invoker.RpcInvoker;

/**
 * @author hanyuzhe
 * @date 2020/2/23 12:23 上午
 * @since 1.0
 */
public class LuConsumer<T> {


    private T proxy;

    public LuConsumer() {
    }

    /**
     * 从注册中心引用一个服务. <T> 即接口类型.
     */
    @SuppressWarnings("unchecked")
    public T ref() {

        if (proxy != null) {
            return proxy;
        }
        proxy = (T) ProxyFactory.getProxy(TargetService.class, new Consumer(new RpcInvoker()));
        return proxy;
    }

}
