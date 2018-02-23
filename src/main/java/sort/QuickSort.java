package sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/16.
 */
public class QuickSort {
    public static void quickSort(int[] nums,int left,int right){
        if (left>=right){
            return;
        }
        // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
        int p = partition(nums,left,right);
        // 左递归
        quickSort(nums,left,p-1);
        // 右递归
        quickSort(nums,p+1,right);
    }

    /**
     * 基准值位置
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] nums,int left,int right){
        // 递归使用快速排序,对arr[l...r]的范围进行排序
        int j = left;
        for (int i = j+1; i <= right; i++) {
            if (nums[i]<nums[left]){
                j++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[j];
        nums[j] = nums[left];
        nums[left] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        Arrays.stream(a).forEach((x)->{
            System.out.print(x+",");
        });
        // 注意右边界的选择，否则会越界
        quickSort(a,0,a.length-1);
        System.out.println();
        Arrays.stream(a).forEach((x)->{
            System.out.print(x+",");
        });
    }
}
