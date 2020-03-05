package top.sinfulxx.AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        //4、以原子方式设置为给定值，并返回旧值，先获取当前对象，在设置新的对象
        SimpleObject test1 = new SimpleObject("test5" , 50);
        AtomicReference<SimpleObject> atomicReference3 = new AtomicReference<>(test1);
        SimpleObject simpleObject2 = atomicReference3.getAndSet(new SimpleObject("test6",50));
        SimpleObject simpleObject3 = atomicReference3.get();
        System.out.println("simpleObject2  Value: " + simpleObject2.toString());
        System.out.println("simpleObject3  Value: " + simpleObject3.toString());
    }
}
