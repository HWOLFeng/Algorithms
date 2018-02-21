package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/13.
 */
public class PrintMatrixClockwise {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        int start = 0;
        // 行
        int row = matrix.length;
        // 列
        int col = matrix[0].length;
        ArrayList<Integer> toPrintArray = new ArrayList<>();
        while (row > start * 2 && col > start * 2) {
            toPrintArray = printMatrixCircle(matrix, col, row, start, toPrintArray);
            start++;
        }
        return toPrintArray;
    }

    public ArrayList<Integer> printMatrixCircle(int[][] matrix,
                                                int col, int row, int start,
                                                ArrayList<Integer> toPrintArray) {
        int endX = col - 1 - start;
        int endY = row - 1 - start;
        // 从左到右
        for (int i = start; i <= endX; i++) {
            toPrintArray.add(matrix[start][i]);
        }
        // 从上到下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                toPrintArray.add(matrix[i][endX]);
            }
        }
        // 从右到左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                toPrintArray.add(matrix[endY][i]);
            }
        }
        // 从下到上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                toPrintArray.add(matrix[i][start]);
            }
        }
        return toPrintArray;
    }

    public static void main(String[] args) {
//        int[][] matrix = new int[3][3];
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                matrix[i][j] = j - i;
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        ArrayList<Integer> arrayList = new PrintMatrixClockwise().printMatrix(matrix);
//        for (Integer integer : arrayList) {
//            System.out.print(integer + " ");
//        }
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(list1);
        list2.get(0).forEach((x)-> System.out.println(x));
        System.out.println();
        list1.add(1);
        list2.add(list1);
        list2.get(0).forEach((x)-> System.out.println(x));
        list2.get(1).forEach((x)-> System.out.println(x));
    }
}
