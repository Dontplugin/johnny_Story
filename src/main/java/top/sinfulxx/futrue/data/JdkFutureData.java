package top.sinfulxx.futrue.data;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author hanyuzhe
 * @date 2020/2/23 4:31 下午
 * @since 1.0
 */
public class JdkFutureData implements Callable<String> {
    private String result;
    private String param;

    public JdkFutureData(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append(param);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        result = sb.toString();

        return result;
    }
}
