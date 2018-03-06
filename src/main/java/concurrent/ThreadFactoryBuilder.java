package concurrent;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.internal.StringUtil;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadFactory建造器，参考netty的DefaultThreadFactory实现
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/4.
 */
public class ThreadFactoryBuilder implements ThreadFactory {

    private static final AtomicInteger poolId = new AtomicInteger();
    private final AtomicInteger nextId;
    private final String prefix;
    private final boolean daemon;
    private final int priority;
    protected final ThreadGroup threadGroup;

    public ThreadFactoryBuilder(String poolName) {
        this((String) poolName, false, 5);
    }

    /**
     * @param poolType 类型
     * @param daemon   是否为守护线程
     * @param priority 优先级
     */
    public ThreadFactoryBuilder(Class<?> poolType, boolean daemon, int priority) {
        this(toPoolName(poolType), daemon, priority);
    }

    public ThreadFactoryBuilder(String poolName, boolean daemon, int priority) {
        // 线程所在的group是否安全的
        this(poolName, daemon, priority, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }

    public ThreadFactoryBuilder(String poolName, boolean daemon, int priority, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        if (poolName == null) {
            throw new NullPointerException("poolName");
        } else if (priority >= 1 && priority <= 10) {
            this.prefix = poolName + '-' + poolId.incrementAndGet() + '-';
            this.daemon = daemon;
            this.priority = priority;
            this.threadGroup = threadGroup;
        } else {
            throw new IllegalArgumentException("priority: " + priority + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
    }

    /**
     * poolName转成小写的
     *
     * @param poolType
     * @return
     */
    private static String toPoolName(Class<?> poolType) {
        if (poolType == null) {
            throw new NullPointerException("poolType");
        } else {
            String poolName = StringUtil.simpleClassName(poolType);
            switch (poolName.length()) {
                case 0:
                    return "unknown";
                case 1:
                    return poolName.toLowerCase(Locale.US);
                default:
                    return Character.isUpperCase(poolName.charAt(0)) && Character.isLowerCase(poolName.charAt(1)) ? Character.toLowerCase(poolName.charAt(0)) + poolName.substring(1) : poolName;
            }
        }
    }

    /**
     * runnable装饰器，带有关闭
     */
    private static final class DefaultRunnableDecorator implements Runnable {
        private final Runnable r;

        DefaultRunnableDecorator(Runnable r) {
            this.r = r;
        }

        @Override
        public void run() {
            try {
                this.r.run();
            } finally {
                FastThreadLocal.removeAll();
            }

        }
    }

    /**
     * 创建新线程方法
     *
     * @param r
     * @return
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread t = this.newThread(new ThreadFactoryBuilder.DefaultRunnableDecorator(r), this.prefix + this.nextId.incrementAndGet());

        try {
            if (t.isDaemon() != this.daemon) {
                t.setDaemon(this.daemon);
            }

            if (t.getPriority() != this.priority) {
                t.setPriority(this.priority);
            }
        } catch (Exception var4) {
            ;
        }

        return t;
    }

    /**
     * 创建新线程
     *
     * @param r    任务
     * @param name 名字
     * @return
     */
    private Thread newThread(Runnable r, String name) {
        return new FastThreadLocalThread(this.threadGroup, r, name);
    }

    /**
     * 外部接口方法
     *
     * @return
     */
    public ThreadFactory build() {
        return this;
    }

}
