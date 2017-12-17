package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/17.
 */
public class ContinuousInteger {

    private static StringBuilder result(int[] num) {
        // 判断是否合法
        int count = 0;
        // 返回的字符串
        StringBuilder s = new StringBuilder();
        // 排序
        Arrays.sort(num);
        for (int i = 0; i < num.length - 1; i++) {
            // 相差过大
            if (num[i+1] - num[i] > 2){
                return s.append("mistake");
            } else if (num[i+1] - num[i] == 2){
                s.append(num[i]+1);
                count++;
            }
        }
        if (count == 0){
            int left = num[0] - 1;
            int right = num[num.length - 1] + 1;
            if (left > 0){
                s.append(left).append(" ");
            }
            if (right < 1000000000){
                s.append(right);
            }
            return s;
        } else if (count == 1){
            return s;
        } else {
            return new StringBuilder().append("mistake");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
        }
        System.out.println(result(num));
    }

}
