package nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表倒数第K个节点
 *
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/2/13.
 */
public class LastKNode {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pFirst = head;
        ListNode pSecond = head;
        for (int i = 0; i < k - 1; i++) {
            if (pFirst.next != null) {
                pFirst = pFirst.next;
            } else {
                return null;
            }
        }
        while (pFirst.next != null) {
            pSecond = pSecond.next;
            pFirst = pFirst.next;
        }
        return pSecond;
    }

    public static void main(String[] args) {
        List<nowcoder.ListNode> listNodes = new ArrayList<>();
        nowcoder.ListNode listNode = new nowcoder.ListNode(10);
        listNodes.add(listNode);
        System.out.println(listNodes.get(0).val);
        listNode.val = 11;
        System.out.println(listNodes.get(0).val);
    }

}
