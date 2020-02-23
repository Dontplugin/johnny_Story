package top.sinfulxx.futrue;

import top.sinfulxx.futrue.data.Data;

/**
 * @author hanyuzhe
 * @date 2020/2/23 3:40 下午
 * @since 1.0
 */
public class FutureMain {

    public static void main(String[] args) {
        Client client = new Client();
        Data ok = client.request("ok");

        System.out.println("请求结束, 开始处理其他业务逻辑");

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("请求结果数据: " + ok.getResult());
    }
}
