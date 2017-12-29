package offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/21.
 */
public class NumberOf1 {
    public static int numberOf1(int n) {
        return Integer.bitCount(Math.abs(n));
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(-1));
        System.out.println(numberOf1(1));

    }
}
/**
 public static int bitCount(int i) {
 // HD, Figure 5-2
 i = i - ((i >>> 1) & 0x55555555);
 i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
 i = (i + (i >>> 4)) & 0x0f0f0f0f;
 i = i + (i >>> 8);
 i = i + (i >>> 16);
 return i & 0x3f;
 }
 */
