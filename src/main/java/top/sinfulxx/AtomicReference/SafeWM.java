package top.sinfulxx.AtomicReference;


import java.util.concurrent.atomic.AtomicReference;

/**
 * 下面的示例代码是合理库存的原子化实现，
 * 其中就是用原子类解决了不可变对象引用的原子性问题。
 */
public class SafeWM {
    class WMRange {
        final int upper;
        final int lower;

        WMRange(int upper, int lower) {
            this.upper = upper;
            this.lower = lower;
        }
    }

    final AtomicReference<WMRange> rf = new AtomicReference<>(
            new WMRange(0, 0)
    );

    // 设置库存上限
    void setUpper(int v) {
        while (true) {
            WMRange or = rf.get();
            // 检查参数合法性
            if (v < or.lower) {
                throw new IllegalArgumentException();
            }
            WMRange nr = new WMRange(v, or.lower);
            if (rf.compareAndSet(or, nr)) {
                return;
            }
        }
    }
}