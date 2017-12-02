package collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/29.
 */
public class BlockingQueueTest {
    private static BlockingQueue blockingQueue;
    public BlockingQueue getBlockingQueue() {
        if (blockingQueue == null) {
            return new LinkedBlockingQueue();
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueTest blockingQueueTest = new BlockingQueueTest();
        BlockingQueue blockingQueue = blockingQueueTest.getBlockingQueue();
        String s = "添加";
        blockingQueue.put(s);
//        System.out.println(blockingQueue.poll());
        // if queue is null process would blocking
        System.out.println(blockingQueue.take());
        // whether queue is null or not poll() always working
        System.out.println(blockingQueue.poll());
        // put and offer
        blockingQueue.put(s);
        blockingQueue.offer(s);
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

    }
}
