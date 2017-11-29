package test;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/11/26.
 */
public class ToBinaryTest {
    public static void main(String[] args) {
        System.out.println(binaryExpression(139));
    }
    public static String binaryExpression(int i){
        String s = Integer.toBinaryString(i);
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(s);
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1'){
                int index = s.length()-j-1;
                stringBuffer.append("2" + "("+index+")" + "+");
            }
        }
        return stringBuffer.toString().substring(0,stringBuffer.length()-1);
    }
}
