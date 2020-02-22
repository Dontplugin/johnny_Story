package top.sinfulxx.rpc;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import top.sinfulxx.rpc.entity.Request;
import top.sinfulxx.rpc.filter.CountFilter;
import top.sinfulxx.rpc.filter.Filter;
import top.sinfulxx.rpc.filter.FilterWrapper;
import top.sinfulxx.rpc.filter.LimitFilter;
import top.sinfulxx.rpc.invoker.Invoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户端调用代理类
 *
 * @author hanyuzhe
 * @date 2020/2/22 10:56 下午
 * @since 1.0
 */
public class Consumer implements InvocationHandler {

    private Invoker rpcInvoker;
    private Invoker invoker;
    private List<Filter> chain;

    public Consumer(Invoker rpcInvoker) {
        this.rpcInvoker = rpcInvoker;
        this.chain = getChain(rpcInvoker);
        this.invoker = buildInvoker(chain);
    }

    private Invoker buildInvoker(List<Filter> chain) {
        Invoker invoker = this.rpcInvoker;

        if (chain != null && chain.size() > 0) {
            for (int i = chain.size() - 1; i >= 0; i--) {
                invoker = new FilterWrapper(chain.get(i), invoker);
            }
        }
        return invoker;
    }

    private List<Filter> getChain(Invoker rpcInvoker) {

        List<Filter> list = new ArrayList<Filter>();
        list.add(new CountFilter());
        list.add(new LimitFilter());

        return list;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setArgs(args);
        request.setMethod(method.getName());

        System.out.println("调用方法: " + request.getMethod() + ", 参数: " + JSONUtil.toJsonStr(args));

        return invoker.invoke(request);
    }



}
