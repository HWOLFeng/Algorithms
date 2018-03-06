package concurrent.chapter6;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/5.
 */
public class Render {
    private final ExecutorService executor;

    public Render(ExecutorService executor) {
        this.executor = executor;
    }

    void renderPage(CharSequence source){

    }
}
