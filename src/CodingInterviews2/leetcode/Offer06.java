package CodingInterviews2.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author lrd
 * @date 2022-09-04 上午9:20
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
public class Offer06 {
/*TODO:递归实现
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：42 MB, 在所有 Java 提交中击败了49.96%的用户
 */
    int []ans;
    int i;//为下标索引
    public int[] reversePrint(ListNode head) {
        recur(head,0);
        return ans;
    }
    void recur(ListNode head,int count){
        if(head==null){
            ans=new int[count];
            i=count-1;
            return;
        }
        recur(head.next,count+1);//count对应了当前元素正序的下标
        ans[i-count] =  head.val;//i-count 为逆序下标
    }

/*
TODO:栈实现
 */
public int[] reversePrint1(ListNode head) {
    Stack<ListNode> stack = new Stack<ListNode>();
    ListNode temp = head;
    while (temp != null) {
        stack.push(temp);
        temp = temp.next;
    }
    int size = stack.size();
    int[] print = new int[size];
    for (int i = 0; i < size; i++) {
        print[i] = stack.pop().val;
    }
    return print;
}


    @Test
    public void test(){
        ListNode l1=new ListNode(1),l2=new ListNode(3),l3=new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        System.out.println(reversePrint(l1)[0]+" "+reversePrint(l1)[1]+" "+reversePrint(l1)[2]+" ");
    }
}
