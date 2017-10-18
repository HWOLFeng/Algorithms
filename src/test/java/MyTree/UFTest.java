package MyTree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UF Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十月 15, 2017</pre>
 */
public class UFTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: union(int p, int q)
     */
    @Test
    public void testUnion() throws Exception {
//TODO: TestStackOfStrings goes here...
    }

    /**
     * Method: connect(int p, int q)
     */
    @Test
    public void testConnect() throws Exception {
//TODO: TestStackOfStrings goes here...
    }

    @Test
    public void test() {
        UF uf = new UF(10);
        uf.union(5,1);
        uf.union(4,9);
        uf.union(3,9);
        uf.union(2,1);
        uf.union(1,8);
        for (int i : uf.getArray()) {
            System.out.print(i);
            System.out.print("...");
        }
    }
} 
