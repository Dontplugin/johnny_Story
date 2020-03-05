package top.sinfulxx.notify;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author hanyuzhe
 * @date 2020/2/25 8:13 下午
 * @since 1.0
 */
public class WaitMain {
    private void wa() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitMain waitMain = new WaitMain();
        waitMain.wa();
    }
}


