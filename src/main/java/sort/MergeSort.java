package sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/16.
 */
public class MergeSort {
    public static void mergesort(int[] nums){
        sort(nums,0,nums.length-1);
    }
    public static void sort(int[]nums,int left,int right){
        // 结束条件
        if (left>=right){
            return;
        }
        int mid = (left+right)/2;
        // 左部分
        sort(nums,left,mid);
        // 右部分
        sort(nums,mid+1,right);
        // 合并
        merge(nums,left,mid,right);
    }
    public static void merge(int[] nums,int left,int mid,int right){
        int[] tempNums = new int[nums.length];
        // 避免右边越界
        int tMid = mid+1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while(left <=mid && tMid <= right) {
            if (nums[left] <= nums[tMid])
                tempNums[tIndex++] = nums[left++];
            else
                tempNums[tIndex++] = nums[tMid++];
        }
        // 将左边剩余的归并
        while (left <=mid) {
            tempNums[tIndex++] = nums[left++];
        }
        // 将右边剩余的归并
        while ( tMid <= right ) {
            tempNums[tIndex++] = nums[tMid++];
        }
        while(cIndex<=right){
            nums[cIndex]=tempNums[cIndex];
            cIndex++;
        }
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        Arrays.stream(a).forEach((x)->{
            System.out.print(x+",");
        });
        mergesort(a);
        System.out.println();
        Arrays.stream(a).forEach((x)->{
            System.out.print(x+",");
        });
    }
}
