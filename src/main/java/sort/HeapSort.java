package sort;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/13.
 */
public class HeapSort {
    int[] heap;
    int heapSize;

    public HeapSort(int[] heap) {
        this.heap = heap;
        this.heapSize = heap.length;
    }

    /**
     * 依次向上构建最大堆，
     */
    public void buildMax() {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxify(i);
        }
    }

    /**
     * 每次输出完，需要重新构建最大堆
     */
    public void sort() {
        for (int i = 0; i < heap.length; i++) {
            swap(0, heapSize - 1);
            heapSize--;
            maxify(0);
        }
    }

    public void maxify(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest;
        if (left < heapSize && heap[left] > heap[i]) {
            largest = left;
        } else {
            largest = i;
        }
        if (right < heapSize && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest == i || largest >= heapSize) {
            return;
        }
        swap(largest, i);
        maxify(largest);
    }

    public void swap(int l, int r) {
        int temp = heap[l];
        heap[l] = heap[r];
        heap[r] = temp;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeft(int i) {
        return 2 * (i + 1) - 1;
    }

    private int getRight(int i) {
        return 2 * (i + 1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        HeapSort heap = new HeapSort(array);
        System.out.println("执行最大堆化前堆的结构：");
        printHeapTree(heap.heap);
        heap.buildMax();
        System.out.println("执行最大堆化后堆的结构：");
        printHeapTree(heap.heap);
        heap.sort();
        System.out.println("执行堆排序后数组的内容");
        printHeap(heap.heap);
    }

    private static void printHeapTree(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int k = i - 1; k < 2 * (i) - 1 && k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
