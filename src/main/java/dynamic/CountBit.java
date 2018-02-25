package dynamic;

/**
 * Created by hwolf on 17/11/22.
 * 每次进位的时候才会+一位，而其余情况都不会进位
 * 0->1->3->7->15
 */
public class CountBit {
    public static void main(String[] args) {
        int[] a = countBits(5);
        for (int i : a) {
            System.out.println(i);
        }
    }
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index){
            if (offset * 2 == index){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }
}
