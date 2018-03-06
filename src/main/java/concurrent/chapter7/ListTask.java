package concurrent.chapter7;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/5.
 */
public class ListTask extends RecursiveAction {
    private static final int THRESHOLD = 1;

    private List<String> processStr;
    private int start;
    private int end;

    public ListTask(List<String> processStr, int start, int end) {
        this.processStr = processStr;
        this.start = start;
        this.end = end;
    }

    /**
     * 给字符串加后缀
     */
    @Override
    protected void compute() {
        boolean isProcess = (end - start) == THRESHOLD;
        if (isProcess) {
            System.out.println(Thread.currentThread().getName());
            String newStr = processStr.get(start) + "-test";
            processStr.set(start, newStr);

        } else {
            System.out.println(Thread.currentThread().getName() + "----");
            int partPos = (start + end) / 2;
            ListTask taskl = new ListTask(processStr, start, partPos);
            ListTask taskr = new ListTask(processStr, partPos, end);
            invokeAll(taskl, taskr);
        }
    }
}
