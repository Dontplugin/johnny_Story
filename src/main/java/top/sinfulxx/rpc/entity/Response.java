package top.sinfulxx.rpc.entity;

/**
 * @author hanyuzhe
 * @date 2020/2/22 11:39 下午
 * @since 1.0
 */
public class Response {
    private boolean stop;
    private String result;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
