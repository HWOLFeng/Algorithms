package Dynamic;

/**
 * Created by hwolf on 17/11/22.
 */
public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int count = 0;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == 0){
                    continue;
                }
                dp[j - 1][j] = A[j] - A[j - 1];
                int diff = dp[j - 1][j];
                if (diff == dp[i][j - 1]) {
                    dp[i][j] = diff;
                    count++;
                }
            }
        }
        return count;
//        int[] dp = new int[A.length];
//        int sum = 0;
//        for (int i = 2; i < dp.length; i++) {
//            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
//         这里的dp是表示，加上之前的
//                dp[i] = 1 + dp[i - 1];
//                sum += dp[i];
//            }
//        }
//        return sum;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = i;
        }
        System.out.println(numberOfArithmeticSlices(A));
    }
/*
public class Solution {
    int sum = 0;
    public int numberOfArithmeticSlices(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }
    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else
            slices(A, i - 1);
        return ap;
    }
}
 */
}
