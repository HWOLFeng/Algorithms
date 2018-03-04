package concurrent.chapter6;

import concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/4.
 */
public class CASCount implements Runnable {
    class SimilatedCAS {
        private int value;

        public int getValue() {
            return this.value;
        }

        public synchronized boolean compareAndSet(int exceptedValue, int newValue) {
            if (value == exceptedValue) {
                value = newValue;
                return true;
            }
            return false;
        }
    }

    SimilatedCAS counter = new SimilatedCAS();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(this.increment());
            }
            System.out.println("====================");
            System.out.println(this.toString());
        }
    }

    public int increment() {
        int oldValue = counter.getValue();
        int newValue = oldValue + 1;
        if (!counter.compareAndSet(oldValue, newValue)) {
            oldValue = counter.getValue();
            newValue = oldValue + 1;
        }
        return newValue;
    }

    public static void main(String[] args) {
        Runnable runnable = new CASCount();
        ThreadFactory nameTheadFactory = new ThreadFactoryBuilder("pool1").build();
        ExecutorService poolExecutor = new ThreadPoolExecutor(5,200,
                0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024),
                nameTheadFactory,new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(runnable);
        }

//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();

    }
}
