package leetcode;

import org.junit.Test;

/**
 * 判断字符串A是否能经过几次移位后与B串相同
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/18.
 */
public class Solution796 {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        int end = A.length();
        for (int i = 0; i < A.length(); i++) {
            String tempA = A.substring(i + 1, end) + A.substring(0, i + 1);
            if (B.equals(tempA)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testRotateString() {
        Solution796 solution796 = new Solution796();
        solution796.rotateString("abcde", "cdeab");
    }
}
