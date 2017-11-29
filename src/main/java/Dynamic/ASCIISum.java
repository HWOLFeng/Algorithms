package Dynamic;

/**
 * 动态规划问题，因为dp[i][s2.length()] = dp[i+1][s2.length()] + s1.codePointAt(i)
 * 所以我们需要拓展一下数组的大小，将s1.length 和 s2.length 都当做边界
 * 也正由此所以我们赋初值的时候是从后往前的，保证 i 越小的时候 sum 越大
 * i 表示剩下的未删除的部分
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/25.
 */
public class ASCIISum {
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.codePointAt(i);
        }

        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j + 1] + s2.codePointAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.codePointAt(i) == s2.codePointAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i),
                            dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        minimumDeleteSum("delete","leet");
    }
}
