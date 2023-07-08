package leetcode.daimasuixianglu;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-06-16 8:20
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
public class Q204 {
    @Leetcode("迭代")
    public ListNode swapPairs(ListNode head) {
        ListNode node=head;
        if(node!=null&&node.next!=null)
            head=node.next;
        while(node!=null&&node.next!=null){
            ListNode tmp=node.next.next;
            node.next.next=node;
            node.next=tmp!=null&&tmp.next!=null?tmp.next:tmp;
            node=tmp;
        }
        return head;
    }
    @Leetcode("递归")
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}
