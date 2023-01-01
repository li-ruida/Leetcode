package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-01 9:58
 * <p>
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class Q2 {
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
    @Leetcode("链表")
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p3 = null,head = null;
        int tmp=0,n1,n2,sum;
        while (l1!=null||l2!=null){
            n1=l1==null?0:l1.val;
            n2=l2==null?0:l2.val;
            sum=n1+n2+tmp;
            tmp=sum/10;
            if (head==null){
                head=new ListNode(sum%10);
                p3=head;
            }
            else {
                p3.next=new ListNode(sum%10);
                p3=p3.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (tmp>0)
            p3.next=new ListNode(tmp);
        return head;
    }
}
