package offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/21.
 */
public class DuplicationInArray {
    private static void duplication(int[] numbers){
        int temp = 0;
        // 已归位位置
        for (int i = 0; i < numbers.length; i++) {
            // 找数
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] != j){
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {1,2,2,4,3,2,3};
        duplication(numbers);
    }
}
