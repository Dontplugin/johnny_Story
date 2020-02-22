package top.sinfulxx.rpc.filter;

import top.sinfulxx.rpc.invoker.Invoker;
import top.sinfulxx.rpc.entity.Request;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:45 下午
 * @since 1.0
 */
public class FilterWrapper implements Invoker {
    private Filter next;
    private Invoker invoker;

    public FilterWrapper(Filter next, Invoker invoker) {
        this.next = next;
        this.invoker = invoker;
    }

    @Override
    public Object invoke(Request request) {

        if (next != null) {
            return next.filter(request, invoker);
        } else {
            return invoker.invoke(request);
        }
    }
}
