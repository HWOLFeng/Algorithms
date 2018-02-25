package concurrent.chapter5;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 参加会议人员类
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/26.
 */
public class Participant implements Runnable {
    private VideoConference conference;

    private String name;

    public Participant(VideoConference conference, String name) {
        this.conference=conference;
        this.name=name;
    }
    @Override
    public void run() {
        Long duration=new Random().nextLong();
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //每到一个人员，CountDownLatch计数器就减少1
        conference.arrive(name);
    }
}
