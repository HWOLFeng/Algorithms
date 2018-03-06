package concurrent.chapter6;


import java.util.concurrent.*;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/5.
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            int sum = 0;
            for (int i = 0; i < 1000000; i++) {
                for (int j = 0; j < 1000; j++) {
                    sum = sum + i +j;
                }
            }
            return sum;
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(callable);

        Thread.sleep(3000);
        System.out.println("--------");
//        int sum = 0;
//        for (int i = 0; i < 1000000; i++) {
//            for (int j = 0; j < 1000; j++) {
//                sum = sum + i +j;
//            }
//        }
        Integer sum = future.get();
        System.out.println("--------");
        System.out.println(sum);
        System.out.println("--------");
    }
}
