package nowcoder;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/4.
 */
public class TwoDimenArrayFind {
    /**
     * 从右上角开始查找，因为看过skipList所以很容易
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        // 行首
        int i = 0;
        // 列尾
        int j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            // 情况一：边界元素
            if (target==array[i][j]){
                return true;
            }
            // 情况二：小于左移
            if (target<array[i][j]){
                j--;
                continue;
            }
            // 情况二：大于下移
            if (target>array[i][j]){
                i++;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10];
//        StringBuilder stringBuilder = new StringBuilder();
        String s = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i + j*11;
                s += a[i][j] + " ,";
            }
            System.out.println(s.substring(0, s.length() - 1));
            s = "";
        }
        System.out.println(new TwoDimenArrayFind().Find(1000,a));
    }
}
