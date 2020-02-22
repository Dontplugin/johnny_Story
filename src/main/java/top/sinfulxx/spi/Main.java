package top.sinfulxx.spi;

import java.util.ServiceLoader;

/**
 * JDK SPI示例
 *
 * @author hanyuzhe
 * @date 2020/2/22 8:52 下午
 * @since 1.0
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<IRepository> serviceLoader = ServiceLoader.load(IRepository.class);
        for (IRepository demoService : serviceLoader) {
            System.out.println("class:" + demoService.getClass().getName());
            demoService.save("tom");
        }
    }
}
