package concurrent.chapter7;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/5.
 */
public class ForkJoinTest1 {
    private final static ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        List<String> list = Arrays.asList("thread-11", "thread-21", "thread-31", "thread-41", "thread-51",
                "thread-61", "thread-71", "thread-81");
        ListTask listTask = new ListTask(list, 0, list.size());
        pool.invoke(listTask);
        System.out.println(JSON.toJSONString(list));
        pool.shutdown();
        if (listTask.isCompletedNormally()) {
            System.out.println("Task 任务顺利完成！");
        }
    }
}
