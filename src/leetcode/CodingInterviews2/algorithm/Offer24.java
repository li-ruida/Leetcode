package leetcode.CodingInterviews2.algorithm;

import org.junit.Test;

/**
 * @author lrd
 * @date 2022-09-15 上午9:31
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 * 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Offer24 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

/*迭代
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：41.1 MB, 在所有 Java 提交中击败了35.14%的用户
 */
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
/*递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：40.7 MB, 在所有 Java 提交中击败了84.26%的用户
 */
@Leetcode("递归")
    public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null){
        return head;
    }
    ListNode newhead=reverseList(head.next);
    head.next.next=head;
    head.next=null;
    return newhead;
    }
    @Test
    public void test(){
        ListNode l1=new ListNode(1),l2=new ListNode(2),l3=new ListNode(3),l4=new ListNode(4),l5=new ListNode(5);
        l1.next=l2;l2.next=l3;l3.next=l4;l4.next=l5;
        ListNode l=reverseList(l1);
        System.out.println(l);
        l=l.next;
    }
}
