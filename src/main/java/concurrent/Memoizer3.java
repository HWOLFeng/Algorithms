package concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 还是使用回调，但是这里使用原子添加的方法，并在计算出现异常的时候移除缓存
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class Memoizer3<S, T> implements Computable<S, T> {
    private final Map<S, Future<T>> cacheMap = new ConcurrentHashMap<>();
    private final Computable<S, T> computable;

    public Memoizer3(Computable<S, T> computable) {
        this.computable = computable;
    }

    @Override
    public T compute(S arg) throws InterruptedException, ExecutionException {
        while (true) {
            Future<T> future = cacheMap.get(arg);
            if (future == null) {
                // 回调
                Callable<T> callable = () -> computable.compute(arg);
                FutureTask<T> futureTask = new FutureTask<T>(callable);
                // "若没有则添加" 原子方法
                future = cacheMap.putIfAbsent(arg, futureTask);
                if (future == null) {
                    future = futureTask;
                    cacheMap.put(arg, futureTask);
                }
            }
            try {
                return future.get();
            } catch (CancellationException c) {
                cacheMap.remove(arg, future);
            }
        }
    }
}
