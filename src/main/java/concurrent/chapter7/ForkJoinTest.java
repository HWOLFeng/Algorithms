package concurrent.chapter7;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/5.
 */
public class ForkJoinTest implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinTest test1 = new ForkJoinTest();
        ForkJoinTest test2 = new ForkJoinTest();
        ForkJoinTest test3 = new ForkJoinTest();
        Thread thread1 = new Thread(test1,"1");
        Thread thread2 = new Thread(test1,"2");
        Thread thread3 = new Thread(test1,"3");
        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("=========");
        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
