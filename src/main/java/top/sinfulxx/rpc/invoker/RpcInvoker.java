package top.sinfulxx.rpc.invoker;

import top.sinfulxx.rpc.entity.Request;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:27 下午
 * @since 1.0
 */
public class RpcInvoker implements Invoker {


    @Override
    public Object invoke(Request request) {


        System.out.println("开始远程调用...");
        return "ok";
    }
}
