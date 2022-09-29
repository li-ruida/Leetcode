package leetcode.CodingInterviews2.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lrd
 * @date 2022-09-29 上午10:15
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class Offer52 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
/*HashSet
执行用时：7 ms, 在所有 Java 提交中击败了7.44%的用户
内存消耗：44 MB, 在所有 Java 提交中击败了89.81%的用户
 */
@Leetcode("HashSet")
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
/*
c个点重复,a+c=m,b+c=n 两轮循环如果相交遇到重复节点
 */
@Leetcode("双指针")
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
