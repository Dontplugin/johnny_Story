package top.sinfulxx.futrue.data;

/**
 * @author hanyuzhe
 * @date 2020/2/23 3:31 下午
 * @since 1.0
 */
public class RealData implements Data {
    private String result;

    public RealData(String param) {
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
    }

    @Override
    public String getResult() {
        return result;
    }
}
