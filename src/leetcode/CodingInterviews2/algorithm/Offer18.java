package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-09-11 上午8:21
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Offer18 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
/*
链表
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：40.7 MB, 在所有 Java 提交中击败了82.91%的用户
 */
@Leetcode("链表删除节点")
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val)
            return head.next;
        ListNode p=head;
        while (p.next!=null){
            if(p.next.val==val){
                p.next=p.next.next;
            }
            else
                p=p.next;
        }
        return head;
    }
}
