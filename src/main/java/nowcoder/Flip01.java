package nowcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/9c4c9d10e3db4448b906c6e6cea22b7f
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2017/12/18.
 */
public class Flip01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();
        System.out.println(BFS(a, b, k));
    }

    public static int BFS(int a, int b, int k) {
        if (a == 0 && b == 0) {
            return 0;
        }
        if (k > a + b) {
            return -1;
        }
        // 初始节点
        Node node = new Node(a, b, 0);
        // 节点队列
        Queue<Node> queue = new LinkedList<>();
        // 状态数组，判断是否剩余 0 的情况访问过
        boolean[] visited = new boolean[a + b + 1];
        queue.add(node);
        visited[a] = true;
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            if (tempNode.a == 0) {
                return tempNode.step;
            }
            // 0 的翻转次数为 i
            // 1 的翻转次数为 k - i
            for (int i = 1; i <= Math.min(tempNode.a, k); i++) {
                if (tempNode.b < k - i) {
                    continue;
                }
                //翻转i个0后，还剩余的0的个数
                int remainA = tempNode.a - i + (k - i);
                if (remainA == 0) {
                    return tempNode.step + 1;
                }
                // 判断该种情况有没有出现过
                if (!visited[remainA]) {
                    visited[remainA] = true;
                    // 步长+1
                    queue.add(new Node(remainA, a + b - remainA, tempNode.step + 1));
                }
            }
        }
        return -1;
    }

}

class Node {
    int a;
    int b;
    int step;

    public Node(int a, int b, int step) {
        this.a = a;
        this.b = b;
        this.step = step;
    }
}
