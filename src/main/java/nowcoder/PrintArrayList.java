package nowcoder;

import java.util.ArrayList;

/**
 * @author hwolf
 * @email h.wolf@qq.com
 * @date 2018/1/4.
 */
public class PrintArrayList {
    ArrayList<Integer> arrayList = new ArrayList();

    /**
     * 递归将所有元素压入栈，最上面的元素就是最后的元素，然后自上而下添加，注意空指针
     * 当然也可以判断当前元素是不是空
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode==null){
            return arrayList;
        }
        if (listNode.next==null){
            arrayList.add(listNode.val);
            return arrayList;
        }
        printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode listNode = new ListNode(0,listNode1);
        ArrayList arrayList;
        arrayList = new PrintArrayList().printListFromTailToHead(null);
        arrayList.stream().forEach((e)->System.out.println(e));
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}