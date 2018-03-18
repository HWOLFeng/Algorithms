package sort;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/10.
 */
public class ShellSort {
    public void swap(int[] numbs, int left, int right) {
        int temp = numbs[left];
        numbs[left] = numbs[right];
        numbs[right] = temp;
    }

    public int[] shellSort(int[] numbs) {
        int gap = numbs.length / 2;
        while (gap > 0) {
            for (int i = gap; i < numbs.length; i++) {
                for (int j = i; j > 0; j = j - gap) {
                    if ((j - gap) >= 0 && numbs[j] < numbs[j - gap]) {
                        swap(numbs, j, j - gap);
                    }
                }
            }
            gap = gap / 2;
        }
        return numbs;
    }

    public static void main(String[] args) {
        int[] numbs = {2, 12, 312, 3, 213, 12, 4, 1, 42123, 1};
        numbs = new ShellSort().shellSort(numbs);
        for (int i = 0; i < numbs.length; i++) {
            System.out.print(numbs[i] + ",");
        }
    }
}
