package sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/16.
 */
public class MergeSort {
    public static void mergeSort(int[] numbs) {
        sort(numbs, 0, numbs.length - 1);
    }

    public static void sort(int[] numbs, int left, int right) {
        // 结束条件
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // 左部分
        sort(numbs, left, mid);
        // 右部分
        sort(numbs, mid + 1, right);
        // 合并
        merge(numbs, left, mid, right);
    }

    public static void merge(int[] numbs, int left, int mid, int right) {
        int[] tempNumbs = new int[numbs.length];
        // 避免右边越界
        int tMid = mid + 1;
        int tIndex = left;
        int cIndex = left;
        // 逐个归并
        while (left <= mid && tMid <= right) {
            if (numbs[left] <= numbs[tMid]) {
                tempNumbs[tIndex++] = numbs[left++];
            } else {
                tempNumbs[tIndex++] = numbs[tMid++];
            }
        }
        // 将左边剩余的归并
        while (left <= mid) {
            tempNumbs[tIndex++] = numbs[left++];
        }
        // 将右边剩余的归并
        while (tMid <= right) {
            tempNumbs[tIndex++] = numbs[tMid++];
        }
        // 复制给numbs
        while (cIndex <= right) {
            numbs[cIndex] = tempNumbs[cIndex];
            cIndex++;
        }
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        Arrays.stream(a).forEach((x) -> {
            System.out.print(x + ",");
        });
        mergeSort(a);
        System.out.println();
        Arrays.stream(a).forEach((x) -> {
            System.out.print(x + ",");
        });
    }
}
