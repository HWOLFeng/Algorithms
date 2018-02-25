package concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * 同步缓存1
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class Memoizer<S,T> implements Computable<S,T> {
    private final Map<S,T> cacheMap = new HashMap<>();
    private final Computable<S,T> computable;

    public Memoizer(Computable<S, T> computable) {
        this.computable = computable;
    }

    @Override
    public synchronized T compute(S arg) throws InterruptedException {
        T result = cacheMap.get(arg);
        if (result == null){
            result = computable.compute(arg);
            // 放入缓存
            cacheMap.put(arg,result);
        }
        return result;
    }
}
