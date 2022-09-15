package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-09-15 上午10:30
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * 0 <= 链表长度 <= 1000
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class Offer25 {
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
/*递归
执行用时：1 ms, 在所有 Java 提交中击败了5.17%的用户
内存消耗：41.6 MB, 在所有 Java 提交中击败了43.44%的用户
 */
@Leetcode("递归")
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        else if(l1.val<= l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
/*迭代
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了90.36%的用户
 */
@Leetcode("迭代")
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans=null,head=new ListNode(-1);
        ans=head;
        while (l1!=null&&l2!=null){
                if(l1.val<= l2.val){
                    ans.next=l1;
                    l1=l1.next;
                }
                else {
                    ans.next=l2;
                    l2=l2.next;
                }
            ans=ans.next;
        }
        if(l1==null){
            ans.next=l2;
        }
        else if(l2==null){
            ans.next=l1;
        }
        return head.next;
    }
}
