package leetcode;

/**
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），假定你只能访问该节点。
 *
 * 删除当前节点 必须知道prev节点， 这里只能访问当前节点，就只能先将next节点的值赋值给当前结点, 再把next节点干掉
 */
public class DeleteNodeDemo {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
