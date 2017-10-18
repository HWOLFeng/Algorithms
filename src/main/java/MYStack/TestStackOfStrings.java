package MYStack;

import java.util.Scanner;

/**
 * @author HWOLF
 * @version create in：17-10-16 下午8:06
 * @descrption
 */
public class TestStackOfStrings {
    @org.junit.Test
    public void test() {
        StackOfStrings stackOfStrings = new StackOfStrings(100);
        System.out.println(stackOfStrings.size() + " left on stack");
        String s = "to be or not to - be - - that - - - is";
        String[] strings = s.split(" ");
        for (int i = 0;i<strings.length;i++){
            String item = strings[i];
            if (!item.equals("-")) stackOfStrings.push(item);
            else if (!stackOfStrings.isEmpty()) System.out.print(stackOfStrings.pop() + " ");
        }
        System.out.println();
        System.out.println(stackOfStrings.size() + " left on stack");
    }
}
