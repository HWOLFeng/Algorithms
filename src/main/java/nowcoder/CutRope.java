package nowcoder;

/**
 * 剪绳子
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/24.
 */
public class CutRope {
    public int maxProductionAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length+1];
        for (int i = 0; i < 4; i++) {
            products[i] = i;
        }
        // i长度下的最大值
        int max = 0;
        for (int i = 4; i <= length; i++) {
            for (int j = 1; j <= i / 2; j++) {
                // 计算每种情况下的最大值
                int product = products[j] * products[i - j];
                if (max<product){
                    max = product;
                }
                // 记录i长度下的最大值
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new CutRope().maxProductionAfterCutting(8));
    }
}
