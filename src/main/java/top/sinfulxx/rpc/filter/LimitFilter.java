package top.sinfulxx.rpc.filter;

import cn.hutool.json.JSONUtil;
import top.sinfulxx.rpc.entity.Request;
import top.sinfulxx.rpc.entity.Response;
import top.sinfulxx.rpc.filter.Filter;
import top.sinfulxx.rpc.invoker.Invoker;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:41 下午
 * @since 1.0
 */
public class LimitFilter implements Filter {
    @Override
    public Object filter(Request request, Invoker invoker) {
        Response response = new Response();
        response.setResult("限流通过");
        response.setStop(false);
        System.out.println(JSONUtil.toJsonStr(response));

        return invoker.invoke(request);
    }
}
