package sort;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/8.
 */
public class QS {
    public void quickSort(int[] numbs, int left, int right) {
        if (left > right) {
            return;
        }
        // 随机选择基准
        int index = (int) (Math.random() * (right - left + 1)) + left;
        // 最左边为基准
        swap(numbs, left, index);
        int start = left;
        int end = right;
        while (start < end) {
            while (numbs[start] < numbs[left] && end > start) {
                start++;
            }
            while (numbs[end] >= numbs[left] && end > start) {
                end--;
            }
            swap(numbs, start, end);
        }
        swap(numbs, left, end);
        quickSort(numbs, left, end - 1);
        quickSort(numbs, end + 1, right);
    }

    public void swap(int[] numbs, int left, int right) {
        int temp = numbs[left];
        numbs[left] = numbs[right];
        numbs[right] = temp;
    }

    public static void main(String[] args) {
        int[] numbs = {2, 3, 21, 2, 3, 21, 1};
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        new QS().quickSort(numbs, 0, numbs.length - 1);
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i] + ",");
        }
        System.out.println();
        new QS().quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
