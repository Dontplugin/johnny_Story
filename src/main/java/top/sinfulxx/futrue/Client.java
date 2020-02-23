package top.sinfulxx.futrue;

import top.sinfulxx.futrue.data.Data;
import top.sinfulxx.futrue.data.FutureData;
import top.sinfulxx.futrue.data.RealData;

/**
 * @author hanyuzhe
 * @date 2020/2/23 3:37 下午
 * @since 1.0
 */
public class Client {

    public Data request(final String param) {
        final FutureData futureData = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(param);
                futureData.setRealData(realData);
            }
        }.start();

        return futureData;
    }
}
