package leetcode.codetop;

/**
 * @author lrd
 * @date 2023-02-26 7:55
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Q83 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        int preval=head.val;
        ListNode p=head.next,pre=head;
        while (p!=null){
            if(p.val==preval){
                pre.next=p.next;
                p=p.next;
            }
            else {
                preval=p.val;
                pre=p;
                p=p.next;
            }
        }
        return head;
    }
}
