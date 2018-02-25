package concurrent;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 使用FutureTask,如果已经在计算则阻塞等待计算结果，如果没在计算则启动计算
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class Memoizer2<S, T> implements Computable<S, T> {
    private final Map<S, Future<T>> cacheMap = new ConcurrentHashMap<>();
    private final Computable<S, T> computable;

    public Memoizer2(Computable<S, T> computable) {
        this.computable = computable;
    }

    @Override
    public T compute(S arg) throws InterruptedException, ExecutionException {
        Future<T> future = cacheMap.get(arg);
        if (future == null) {
            // 回调
            Callable<T> eval = () -> computable.compute(arg);
            FutureTask<T> futureTask = new FutureTask<T>(eval);
            future = futureTask;
            cacheMap.put(arg, futureTask);
            // 开始调用计算
            futureTask.run();
        }
        return future.get();
    }
}
