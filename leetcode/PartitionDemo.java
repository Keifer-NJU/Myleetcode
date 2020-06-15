package leetcode;

public class PartitionDemo {

     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    /**
     * 方法1 执行用时 :
     * 1 ms, 在所有 Java 提交中击败了36.48%的用户内存消耗 :37.7 MB, 在所有 Java 提交中击败了100.00%的用户
     * 二次提交 100%
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;
        ListNode listNode = head.next;
        ListNode pre = head;
        while(listNode!=null){
            if(listNode.val<x){
                pre.next = listNode.next;
                listNode.next = head;
                head  = listNode;
                listNode = pre.next;
            }
            else {
                pre = pre.next;
                listNode = listNode.next;
            }
        }
        return head;
    }
}
