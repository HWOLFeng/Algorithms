package stringBuffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/1.
 */
public class SelfDividingNumbers {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            char[] charTemp = Integer.toString(i).toCharArray();
            for (int j = 0; j < charTemp.length; j++) {
                if (charTemp[j] == '0'){
                    break;
                }else if ((i % (charTemp[j] - '0')) > 0){
                    break;
                }
                if (j==charTemp.length-1){
                    list.add(i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = selfDividingNumbers(47,85);
        System.out.println(list.toString());
    }
}
