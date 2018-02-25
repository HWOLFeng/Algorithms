package concurrent.chapter5;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class PrintQueue {
    private Semaphore semaphore;
    private boolean[] freePrinters;
    private Lock lockPrinters;

    public PrintQueue() {
        // 信号量为3
        semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true;
        }
        // 重录锁
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            // 信号量减一
            semaphore.acquire();

            int assignedPrinter = getPrinter();

            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
                    Thread.currentThread().getName(),
                    assignedPrinter,
                    duration);
            TimeUnit.SECONDS.sleep(duration);

            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放信号量
            semaphore.release();
        }
    }

    private int getPrinter() {
        int ret = -1;

        try {
            // 加锁
            lockPrinters.lock();
            // 第几号在打印
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
