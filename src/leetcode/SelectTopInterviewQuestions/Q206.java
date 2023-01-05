package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-05 11:00
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 */
public class Q206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Leetcode("递归")
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode newhead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
    @Leetcode("迭代")
    public ListNode reverseList1(ListNode head) {
        ListNode pre=null,now=head,temp=null;
        while (now!=null){
            temp=now.next;//存储下一个节点
            now.next=pre;
            pre=now;//存储当前节点
            now=temp;
        }
        return pre;
    }
}
