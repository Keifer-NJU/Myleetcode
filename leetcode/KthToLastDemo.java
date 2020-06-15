package leetcode;

public class KthToLastDemo {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
