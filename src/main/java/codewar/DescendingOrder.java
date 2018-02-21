package codewar;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

/**
 * 排序非负int
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/21.
 */
public class DescendingOrder {
    public static int sortDesc(final int num) {
        //Your code
        char[] numChar = Integer.toString(num).toCharArray();
        Character[] numCharacter = new Character[numChar.length];
        for (int i = 0; i < numChar.length; i++) {
            numCharacter[i] = numChar[i];
        }
        Comparator<Character> comparator = (x1, x2) -> Character.compare(x2, x1);
        Arrays.sort(numCharacter, comparator);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numCharacter.length; i++) {
            stringBuilder.append(numCharacter[i]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    @Test
    public void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
}
