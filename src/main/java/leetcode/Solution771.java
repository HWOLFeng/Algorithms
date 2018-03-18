package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 771. Jewels and Stones
 * 给定两个字符串，判断第二个字符串有多少个字符属于第一个字符串
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/3/18.
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || "".equals(J)) {
            return 0;
        }
        // 计数值
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if (S.charAt(i) != J.charAt(j)){
                    continue;
                }
                count++;
            }
        }
        return count;
    }
    @Test
    public void testNumJewelsInStones(){
        Solution771 solution771 = new Solution771();
        Assert.assertEquals(3,solution771.numJewelsInStones("aA","aAAbbbb"));
        Assert.assertEquals(0,solution771.numJewelsInStones("z","ZZ"));
    }

}
