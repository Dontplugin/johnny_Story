package top.sinfulxx.rpc.entity;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author 莫那·鲁道
 * @date 2018/10/14-下午9:39
 */
public class Request implements Serializable {
    private String method;
    private Object[] args;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
