package concurrent;

import java.util.concurrent.ExecutionException;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public interface Computable<S, T> {
    T compute(S arg) throws InterruptedException, ExecutionException;
}
