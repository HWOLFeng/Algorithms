package concurrent.chapter6;

import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletionService;
import java.util.concurrent.DelayQueue;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/4.
 */
public class ThreadTaskWebServer {
    ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(10);
    DelayQueue delayQueue = new DelayQueue();
    @Test
    public void test() throws InterruptedException {
        System.out.println(blockingQueue.size());
        for (int i = 0; i < 10; i++) {
            blockingQueue.put(i);
        }
//        blockingQueue.offer(11);
        System.out.println(blockingQueue.size());
        System.out.println("=_=");
        for (int i = 0; i < blockingQueue.size(); i++) {
            System.out.println(blockingQueue.size());
            System.out.println(blockingQueue.poll());
            System.out.println("======");
        }
        System.out.println("=======--=-=-=-=-=-=-=-=-=");
        Iterator iterator = blockingQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
