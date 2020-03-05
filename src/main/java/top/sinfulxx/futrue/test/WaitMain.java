package top.sinfulxx.futrue.test;

/**
 * wait(), notify() 使用示例
 * 注意: 在调用wait（）之前，线程必须要获得该对象的对象级别锁，即只能在同步方法或同步块中调用wait（）方法。
 * 进入wait（）方法后，当前线程释放锁。在从wait（）返回前，线程与其他线程竞争重新获得锁。如果调用wait（）时，
 * 没有持有适当的锁，则抛出IllegalMonitorStateException，它是RuntimeException的一个子类，
 * 因此，不需要try-catch结构。
 *
 * @author hanyuzhe
 * @date 2020/2/23 4:00 下午
 * @since 1.0
 */
public class WaitMain {

    public static void main(String[] args) {
        final Wait wait = new Wait();
        new Thread("1") {
            @Override
            public void run() {
                wait.scan();
            }
        }.start();

        new Thread("2") {
            @Override
            public void run() {
                wait.scan();
            }
        }.start();

        try {
            Thread.sleep(10000);
            wait.ok();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
