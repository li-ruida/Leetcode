package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

import java.lang.management.BufferPoolMXBean;

/**
 * @author lrd
 * @date 2023-01-08 9:13
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Q19 {
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
    @Leetcode("双指针")
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newhead=new ListNode(0,head);//创建新的头结点,无需讨论头节点是否被删除
        ListNode fast=head,slow=newhead;
        int count=0;
        while (fast!=null&&count<n){
            fast=fast.next;
            count++;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return newhead.next;
    }
}
