package concurrent.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * 会议室里等与会人员到齐了会议才能开始
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/26.
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;

    /**
     * 初始化总共有多少人
     * @param number
     */
    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    /**
     * 到达
     * @param name
     */
    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        //调用countDown()方法，使内部计数器减1
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
        try {
            //等待，直到CountDownLatch计数器为0
            controller.await();

            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
