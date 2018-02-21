package nowcoder;

import java.util.Arrays;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/19.
 */
public class QuickSort {
    public void quickSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int partition = partition(nums, start, end);
        // 保证没有越界
        if (start < partition) {
            // 排左边
            quickSort(nums, start, partition - 1);
        }
        // 没有越界
        if (end > partition) {
            // 排右边
            quickSort(nums, partition + 1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return 0;
        }
        // 以最左边为基准
        int small = start;
        int temp;
        // 查找整个数组，当还代表大数的位置
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < nums[start]) {
                // 向右移动
                small++;
                // 越过连续大数，交换，保证连续数都是小
                if (small != i) {
                    temp = nums[i];
                    nums[i] = nums[small];
                    nums[small] = temp;
                }
            }
        }
        // 头尾交换
        temp = nums[small];
        nums[small] = nums[start];
        nums[start] = temp;
        // 返回基准
        return small;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        quickSort.quickSort(a, 0, a.length - 1);
        Arrays.stream(a).forEach((x) -> {
            System.out.print(x + ",");
        });
    }
}
