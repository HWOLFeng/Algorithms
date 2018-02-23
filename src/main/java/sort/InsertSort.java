package sort;

import java.util.Arrays;

/**
 * 插入排序，n比较小的时候优势比较大，所以一般是高级算法处理小部分数据的算法
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/16.
 */
public class InsertSort {
    public int[] insertSort(int[] nums) {
        // 元素位置
        int i;
        // 已排序个数
        int j = 0;
        // 需要被排序的数
        int keyNum;
        // 开始升序序
        for (i = 1; i < nums.length; i++) {
            keyNum = nums[i];
            // 之前已经排序的元素
            j = i - 1;
            // 待排序元素小于已排序元素
            while (j >= 0 && keyNum < nums[j]) {
                // 元素进行后移
                nums[j+1] = nums[j];
                // 最后会多减一次
                j--;
            }
            // 填上元素
            nums[j+1] = keyNum;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] a = {2,3,2,12,3,4,5,1};
        int[] b = {1,1,1,2,3,4,5,6};
        int[] c = {8,7,6,5,4,3,2,1};
        int[] sortedA = new InsertSort().insertSort(c);
        Arrays.stream(sortedA).forEach((x)->{
            System.out.print(Integer.toString(x)+",");
        });

    }
}
