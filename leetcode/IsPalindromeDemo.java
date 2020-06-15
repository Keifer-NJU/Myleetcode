package leetcode;
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//    }
//}
public class IsPalindromeDemo {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        if(head.next.next==null)return (head.val==head.next.val);
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode temp = head.next;
        ListNode pre = head;
        //新加 变量
        ListNode temp2 ;
        while(fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = temp;
            temp2 = temp.next;
            slow.next = pre;
            pre = slow;
            temp = temp2;
            /**
             * 下面是原先的代码， 有问题，问题在于slow 指向 temp ,然后temp变了，slow也就跟着变了
             */
//            slow = temp;
//            temp = slow.next;
//            slow.next = pre;
//            pre = slow;
//            fast = fast.next.next;
        }
        if(fast.next==null)fast=temp;
        else fast=temp.next;
        while (fast!=null) {
            if (slow.val!=fast.val)return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
