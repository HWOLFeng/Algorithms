package StringBuffer;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = sb.append(1);

        System.out.println(sb1==sb);
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
    }
}
