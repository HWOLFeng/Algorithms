package codewar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 斐波那契数列升级版 AKA Tribonacci
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/21.
 */
public class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }
        double[] allNumbs = new double[n];
        if (n <= 3) {
            for (int i = 0; i < n; i++) {
                allNumbs[i] = s[i];
            }
            return allNumbs;
        }
        for (int i = 0; i < s.length; i++) {
            allNumbs[i] = s[i];
        }
        for (int index = 3; index < n; index++) {
            allNumbs[index] = allNumbs[index - 1] + allNumbs[index - 2] + allNumbs[index - 3];
        }
        return allNumbs;
    }

    private Xbonacci variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new Xbonacci();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    private double precision = 1e-10;

    @Test
    public void basicTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, variabonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, variabonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, variabonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
    }
}
