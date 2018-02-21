package codewar;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 替换字符串
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/20.
 */
public class DuplicateEncoder {
    static String encode(String word) {
        String tempWord = word.toLowerCase();
        Stack<Character> stack = new Stack<>();
        boolean[] tempBoolean = new boolean[tempWord.length()];
        // 全部为 false 表示未鉴定
        Arrays.fill(tempBoolean, false);
        for (int i = 0; i < tempWord.length(); i++) {
//            Character temp = tempWord.charAt(i);
//            if (!stack.contains(temp) && temp != ')') {
//                stack.add(temp);
//                continue;
//            }
//            if (stack.isEmpty()){
//                continue;
//            }
//            stack.remove(temp);
//            tempWord = tempWord.replace(temp, ')');
            Character temp = tempWord.charAt(i);
            // 首次出现的字符压入栈
            if (!stack.contains(temp)) {
                stack.add(temp);
                continue;
            }
            if (stack.isEmpty()) {
                continue;
            }
            // 找到第一个出现的字符
            int index = tempWord.indexOf(temp);
            tempBoolean[index] = true;
            tempBoolean[i] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tempBoolean.length; i++) {
            if (tempBoolean[i] == true){
                stringBuilder.append(')');
            }else {
                stringBuilder.append('(');
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        assertEquals(")()())()(()()(",
                DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))", DuplicateEncoder.encode("   ()(   "));
    }
}
