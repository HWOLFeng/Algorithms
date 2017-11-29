package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 实现，当计数值为 5 的时候t2线程输出语句
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/29.
 */
public class LatchTest {

    // attention to new
    volatile List list = new ArrayList();

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return list.size();
    }
    public static void main(String[] args) {
        LatchTest latchTest = new LatchTest();

        // number of Latch
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(()->{
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                latchTest.add(new Object());
                if (latchTest.size() == 5){
                    latch.countDown();
                }
                System.out.println(i);
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 end");
        },"t1").start();

        new Thread(() -> {
            System.out.println("t2 start");
            try {
                if (latchTest.size()!=5){
                    latch.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        },"t2").start();
    }
}
