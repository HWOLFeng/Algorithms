package sort;

import java.util.Arrays;

/**
 * 二路快排
 * 1. 先是确定基准，以最左边为基准
 * 2. 移动左指针，遇到numbers[i]>numbers[index]就停下，其余情况i++
 * 3. 移动右指针，遇到numbers[i]<numbers[index]就停下，其余情况j--
 * 4. 交换左右指针位置
 * 5. 当i>j 停下，swap(numbers[index],numbers[j])
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/22.
 */
public class QuickSort2 {
    public void quickSort2(int[] numbers, int left, int right) {
        // 递归中止条件
        if (left > right) {
            return;
        }
        // 基准
        int index = partition(numbers, left, right);
        // 排左边
        quickSort2(numbers, left, index - 1);
        // 排右边
        quickSort2(numbers, index + 1, right);
    }

    public int partition(int[] numbers, int left, int right) {
        int index = (int) (Math.random() * (right - left + 1)) + left;
        swap(numbers, left, index);
        int i = left;
        int j = right;
        while (i < j) {
            while (numbers[left] > numbers[i] && i <= right) {
                i++;
            }
            while (numbers[left] <= numbers[j] && j >= left + 1) {
                j--;
            }
            swap(numbers, i, j);
        }
        // 最后需要将最左边的基准放到中间
        swap(numbers, left, j);
        return j;
    }

    public void swap(int[] numbers, int x1, int x2) {
        int temp = numbers[x1];
        numbers[x1] = numbers[x2];
        numbers[x2] = temp;
    }

    public static void main(String[] args) {
        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        int[] b = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1, 26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        new QuickSort2().quickSort2(a, 0, a.length - 1);
        Arrays.stream(a).forEach((x) -> System.out.print(x + ","));
        System.out.println();
        new QuickSort2().quickSort2(b, 0, b.length - 1);
        Arrays.stream(b).forEach((x) -> System.out.print(x + ","));
    }
}
