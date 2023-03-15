package leetcode.codetop;

/**
 * @author lrd
 * @date 2023-03-15 10:10
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Q82_2 {
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
          ListNode newhead=new ListNode(0,head);
          ListNode cur=newhead;
          while (cur.next!=null&&cur.next.next!=null){
                if(cur.next!=null&&cur.next.next!=null){
                      if(cur.next.val==cur.next.next.val){
                            int x=cur.next.val;
                            while (cur.next!=null&&cur.next.val==x){
                                  cur.next=cur.next.next;
                            }
                      }else {
                            cur=cur.next;
                      }
                }
          }
          return newhead.next;
    }
}
