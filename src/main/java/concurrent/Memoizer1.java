package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class Memoizer1<S, T> implements Computable<S, T> {
    private final Map<S, T> concurrentHashMap = new ConcurrentHashMap<>();
    private final Computable<S, T> computable;

    public Memoizer1(Computable<S, T> computable) {
        this.computable = computable;
    }

    /**
     * 不用synchronized
     *
     * @param arg
     * @return
     * @throws InterruptedException
     */
    @Override
    public T compute(S arg) throws InterruptedException, ExecutionException {
        T target = concurrentHashMap.get(arg);
        if (target == null) {
            target = computable.compute(arg);
            // 放入缓存
            concurrentHashMap.put(arg, target);
        }
        return target;
    }
}
