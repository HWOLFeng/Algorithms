package concurrent;

import java.math.BigInteger;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/25.
 */
public class ExpensiveFunction implements Computable<String,BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
