package codewar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 增长率
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/20.
 */
public class Arge {
    public static int nbYear(int p0, double percent, int aug, int p) {
        if (p < p0) {
            return 0;
        }
        int count = 0;
        int sum = p0;
        while (sum < p) {
            sum = sum + (int) (sum * percent) / 100 + aug;
            count++;
        }
        return count;
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: nbYear");
        testing(Arge.nbYear(1500, 5, 100, 5000), 15);
        testing(Arge.nbYear(1500000, 2.5, 10000, 2000000), 10);
        testing(Arge.nbYear(1500000, 0.25, 1000, 2000000), 94);
    }
}
