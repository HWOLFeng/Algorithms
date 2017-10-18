package search;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * StaticSETofInts Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十月 18, 2017</pre>
 */
public class StaticSETofIntsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: contain(int key)
     */
    @Test
    public void testContain() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: rank(int key)
     */
    @Test
    public void testRank() throws Exception {
//   7个
        int[] keysOdd = {5, 54, 7, 8, 6, 2, 1};
//   6个
        int[] keysEven = {4, 7, 8, 45, 6, 1};

        StaticSETofInts staticSETofIntsOdd = new StaticSETofInts(keysOdd);
        StaticSETofInts staticSETofIntsEven = new StaticSETofInts(keysEven);
        System.out.println(staticSETofIntsEven.rank(5));
        System.out.println(staticSETofIntsEven.rank(4));
        System.out.println(staticSETofIntsOdd.rank(5));
        System.out.println(staticSETofIntsOdd.rank(4));
    }


} 
