package leetcode;

import java.util.HashSet;

public class RemoveDuplicateNodesDrmo {
    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        if(head==null||head.next==null) return head;
        ListNode temp = head.next;
        ListNode pre = head;
        hashSet.add(pre.val);
        while(temp!=null){
            if(hashSet.contains(temp.val)){
                pre.next = temp.next;
            }
            else {
                hashSet.add(temp.val);
                pre = temp;
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * 方法2  用数组代替 时间复杂度减少
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes1(ListNode head) {
        int[] hashArray = new int[20001];
        if(head==null||head.next==null) return head;
        ListNode temp = head.next;
        ListNode pre = head;
        hashArray[head.val]++;
        while(temp!=null){
            if(hashArray[temp.val]!=0){
                pre.next = temp.next;
            }
            else {
                hashArray[temp.val]++;
                pre = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
