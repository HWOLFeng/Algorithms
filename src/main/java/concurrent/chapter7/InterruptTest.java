package concurrent.chapter7;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/5.
 */
public class InterruptTest extends Thread{
    private BlockingQueue<Long> blockingQueue;
    private boolean flag;

    public InterruptTest(BlockingQueue<Long> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        long i = Thread.currentThread().getId();
        while(!Thread.currentThread().isInterrupted()){
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                System.out.println(blockingQueue.size());
//                Iterator<Long> iterator = blockingQueue.iterator();
//                while (iterator.hasNext()){
//                    System.out.println(iterator.next());
//                }
                e.printStackTrace();
            }
        }
    }

    public void cancel(){
        interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Long> blockingQueue = new ArrayBlockingQueue(10000);
        InterruptTest interruptTest = new InterruptTest(blockingQueue);

        interruptTest.start();
        Thread.sleep(5);
        interruptTest.cancel();
        Thread.sleep(5);
//        interruptTest.cancel(true);

        Iterator<Long> iterator = blockingQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
