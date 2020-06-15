package leetcode;

/**
 * 2. 两数相加 给出两个 非空 的链表用来表示两个非负的整数。
 *      其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 方法1 ： 链表换成数字计算 ， 但是测试数值 超过long的范围
 * 方法2： 直接链表一个个算， 用变量表示进位  适用
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class AddTwoNumbersDemo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode resultList=null;
        /**
         * int的范围 只能 -2^31~2^31-1  测试中超过就错了， 所以改用long
         * 后来发现 long也超过了  悲剧
         */
//        int num_l1 = 0;
//        int num_l2 = 0;
        long num_l1 = 0;
        long num_l2 = 0;
        int count1 = 0;
        while(temp.next!=null){
            num_l1 += (long) (temp.val * Math.pow(10,count1));
            temp = temp.next;
            count1++;
        }
        if(temp.val==0){
            return l2;
        }
        num_l1 += (long) (temp.val * Math.pow(10,count1));
        count1 = 0;
        temp = l2;
        while(temp.next!=null){
            num_l2 += (long) (temp.val * Math.pow(10,count1));
            temp = temp.next;
            count1++;
        }
        if (temp.val==0){
            return l1;
        }
        num_l2 += (long) (temp.val * Math.pow(10,count1));
        num_l1 = num_l2 + num_l1;
        count1 = 1;
        int listValue;
        ListNode tempList=null;
        while(num_l1>0){
            listValue = (int) (num_l1 % 10);
            if(tempList==null){
                tempList = new ListNode(listValue);
                resultList = tempList;
            }
            else {
                tempList.next = new ListNode(listValue);
                tempList = tempList.next;
            }
            num_l1 = num_l1 / 10;
//            count1++;
        }
        return resultList;
    }
    /**
     * 另一种方法
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        /**
         * 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
         * 在最后返回时 返回resultList.next()
         */
        ListNode resultList = new ListNode(0);
        int temp1,temp2,temp3;
        int carry = 0;
        ListNode tempList = resultList;
        while(l1!=null||l2!=null){
            /**
             * 下面这段 用问号表达式 优化排版
             */
//            if(l1==null){
//                temp1 = 0;
//            }
//            else {
//                temp1 = l1.val;
//            }
//            if (l2==null){
//                temp2 = 0;
//            }
//            else {
//                temp2 = l2.val;
//            }
            temp1 = (l1==null)?0:l1.val;
            temp2 = (l2==null)?0:l2.val;
            temp3 = temp1 + temp2 + carry;
            carry = 0;
            if(temp3>9){
                temp3 = temp3 - 10;
                carry = 1;
            }
            tempList.next = new ListNode(temp3);
            tempList = tempList.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        if(carry==1)tempList.next = new ListNode(1);
        return resultList.next;
    }
//    public static void main(String[] args) {
//        int num_l1 = 807;
//        int listValue;
//        while(num_l1>0){
//            listValue = num_l1 % 10;
//            System.out.println(listValue);
//            num_l1 = num_l1 / 10;
////            count1++;
//        }
//    }
}
