package concurrent.chapter5;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class TestJob {
    @Test
    public void testPrint() {
        PrintQueue printQueue = new PrintQueue();
        Thread[] thread = new Thread[12];
//        ThreadFactory threadFactory = (ThreadFactory) new Job(printQueue);
//        ExecutorService executor = new ThreadPoolExecutor(12,
//                100,
//                0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingDeque<>(1024),threadFactory,
//                new ThreadPoolExecutor.AbortPolicy());
//        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 12; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
//            Job job = new Job(printQueue);
//            service.execute(job);
        }
        for (int i = 0; i < 12; i++) {
            thread[i].start();
        }
    }
}
