package codewar;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 选择排序
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/20.
 */
public class Kata {
    public static int[] sortArray(int[] array) {
        if (array.length == 0){
            return array;
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] % 2 != 0 && (array[j] < min)) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    @Test
    public void exampleTest1() {
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, Kata.sortArray(new int[]{5, 3, 2, 8, 1, 4}));
    }

    @Test
    public void exampleTest2() {
        assertArrayEquals(new int[]{1, 3, 5, 8, 0}, Kata.sortArray(new int[]{5, 3, 1, 8, 0}));
    }

    @Test
    public void exampleTest3() {
        assertArrayEquals(new int[]{}, Kata.sortArray(new int[]{}));
    }
}
