package nowcoder;


/**
 * 面试12 矩阵中的路径
 * 回溯法，类似树形
 * 1. 上下左右选择可能得节点，如果满足选择下一个节点
 * 2. 如果不满足，该路径无效，回溯
 * 3. 不满足：到达边界，不满足条件
 * 4. 所有遍历完
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/22.
 */
public class MatrixPath {
    /**
     * @param matrix 矩阵
     * @param rows   行
     * @param cols   列
     * @param str    路径
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (condition(matrix, i, j, rows, cols, str, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean condition(char[] matrix, int i, int j, int rows, int cols, char[] str, int start, boolean[] visited) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[start] || visited[index] == true) {
            return false;
        }
        if (start == str.length - 1) {
            return true;
        }
        visited[index] = true;
        if (condition(matrix, i + 1, j, rows, cols, str, start + 1, visited) ||
                condition(matrix, i, j + 1, rows, cols, str, start + 1, visited) ||
                condition(matrix, i - 1, j, rows, cols, str, start + 1, visited) ||
                condition(matrix, i, j - 1, rows, cols, str, start + 1, visited)) {
            return true;
        }
        visited[index] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        char[] str1 = {'a','b','f','b'};
        boolean has = new MatrixPath().hasPath(matrix,3,4,str);
        boolean has1 = new MatrixPath().hasPath(matrix,3,4,str1);
        System.out.println(has);
        System.out.println(has1);
    }
}
