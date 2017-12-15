package netty;

import java.util.concurrent.*;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/7.
 */
public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task1 = () -> System.out.println("I am tasks1 ...");
        Callable<Integer> task2 = () -> new Integer(100);
        Future<?> f1 = executor.submit(task1);
        Future<Integer> f2 = executor.submit(task2);
        System.out.println("task1 is complete??? " + f1.isDone());
        // 这里 f2.isDone 是将来可能会用上的值，如果f2.get 一直没执行。。
        System.out.println("task2 is complete??? " + f2.isDone());
        while (f1.isDone()){
            System.out.println("task1 complete");
            break;
        }
        while (f2.isDone()){
            System.out.println("task2 complete f2 value"+ f2.get());
            break;
        }
    }
}
