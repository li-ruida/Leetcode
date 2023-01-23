package leetcode.Hot100;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-23 9:49
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 */
public class Q234 {
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
    ListNode tmp;
    public boolean isPalindrome(ListNode head) {
        tmp=head;
        return check(head);
    }
    public boolean check(ListNode node){
        if(node!=null){
            if(!check(node.next))//递归到末尾节点
                return false;//递归结束判断上层节点是否符合要求
            if(node.val!=tmp.val)
                return false;
            tmp=tmp.next;
        }
        return true;
    }
}
