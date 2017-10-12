package StringBuffer;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = sb.append("3")
                .append(".1")
                .reverse();
        System.out.println(sb.toString());
        System.out.println(sb1.toString());
    }
}
