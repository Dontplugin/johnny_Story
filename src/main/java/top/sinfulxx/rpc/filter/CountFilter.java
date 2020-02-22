package top.sinfulxx.rpc.filter;

import cn.hutool.json.JSONUtil;
import top.sinfulxx.rpc.entity.Request;
import top.sinfulxx.rpc.entity.Response;
import top.sinfulxx.rpc.invoker.Invoker;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:41 下午
 * @since 1.0
 */
public class CountFilter implements Filter {
    private static AtomicInteger COUNT = new AtomicInteger(0);

    @Override
    public Object filter(Request request, Invoker invoker) {
        Response response = new Response();
        response.setResult("当前计数: " + COUNT.addAndGet(1));
        response.setStop(false);
        System.out.println(JSONUtil.toJsonStr(response));

        return invoker.invoke(request);
    }
}
