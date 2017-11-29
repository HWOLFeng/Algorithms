package Dynamic;

import java.util.Arrays;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/25.
 */
public class MaximumPairChain {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                //终点是不是大于起点
                dp[i] = Math.max(dp[i], pairs[i][0] > pairs[j][1] ? dp[j] + 1 : dp[j]);
            }
        }

        return dp[pairs.length-1];
    }

    public static void main(String[] args) {

    }
}
