package concurrent.chapter5;

import org.junit.Test;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/26.
 */
public class TestConf {
    @Test
    public void test() {
        VideoConference conference = new VideoConference(10);
        Thread threadConference = new Thread(conference);
        //开启await()方法，在内部计数器为0之前线程处于等待状态
        threadConference.start();
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.run();
//            t.start();
        }
    }
}
