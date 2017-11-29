package Dynamic;

/**
 * Created by hwolf on 17/11/22.
 */
public class CountSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
        System.out.println(countSubstrings("aaaa"));
        System.out.println(countSubstrings("aaaaa"));
//        longestPalindrome("aaabaaba");
    }

    //    public static int countSubstrings(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            //odd length case
//            extendPalindrome(s,i,i);
//            //even length case
//            extendPalindrome(s,i,i+1);
//        }
//        System.out.println(count);
//        return count;
//    }
    public static int countSubstrings(String s) {
        int count = 0;
        if (s.length() == 0 || s == null) {
            return 0;
        }
        boolean[][] pal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 3 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }

    //    public static int countSubstrings(String s) {
//        int n = s.length();
//        int res = 0;
//        boolean[][] dp = new boolean[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//                if(dp[i][j]) ++res;
//            }
//        }
//        return res;
//    }

//    public static int longestPalindrome(String s) {
//        int n=s.length();
//        boolean[][] pal=new boolean[n][n];
//        //pal[i][j] 表示s[i...j]是否是回文串
//        int maxLen=0;
//        for (int i=0;i<n;i++){  // i作为终点
//            int j=i;    //j作为起点
//            while (j>=0){
//                //j+1 -> i-1就是j -> i的子串，所以如果子串是回文串，那么j -> i 就是回文串
//                if (s.charAt(j)==s.charAt(i)&&(i-j<2||pal[j+1][i-1])){
//                    pal[j][i]=true;
//                    maxLen=Math.max(maxLen, i-j+1);
//                }
//                j--;
//            }
//        }
//        return maxLen;
//    }


//    private static void extendPalindrome(String s, int left, int right) {
//        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            System.out.println(s.substring(left,right+1));
//            count++;
//            left--;
//            right++;
//        }
//    }
}
