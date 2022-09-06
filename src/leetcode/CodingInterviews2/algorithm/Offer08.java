package leetcode.CodingInterviews2.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author lrd
 * @date 2022-09-06 上午8:22
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 *  * Your CQueue object will be instantiated and called as such:
 *  * CQueue obj = new CQueue();
 *  * obj.appendTail(value);
 *  * int param_2 = obj.deleteHead();
 *
 */

public class Offer08 {
/*
todo:栈2存栈1
执行用时：1818 ms, 在所有 Java 提交中击败了5.11%的用户
内存消耗：48.1 MB, 在所有 Java 提交中击败了73.16%的用户
 */
    class CQueue {
        //Stack<Integer> stack1,stack2;
        Stack<Integer> stack1,stack2;
        public CQueue() {
            stack1=new Stack<>() ;
            stack2=new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            int ans=-1;
            while (!stack1.empty()){
                stack2.push(stack1.peek());
                ans=stack1.peek();
                stack1.pop();
            }
            if(!stack2.empty())
                stack2.pop();
            while (!stack2.empty()){
                stack1.push(stack2.peek());
                stack2.pop();
            }

            return ans;
        }
    }
/*
推荐使用Deque，因为java的Stack是线程安全的，效率较低
执行用时：205 ms, 在所有 Java 提交中击败了13.79%的用户
内存消耗：48 MB, 在所有 Java 提交中击败了79.01%的用户
 */
class CQueue1 {
    //Stack<Integer> stack1,stack2;
    Deque<Integer> stack1,stack2;
    public CQueue1() {
        stack1=new ArrayDeque<>() ;
        stack2=new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        int ans=-1;
        while (!stack1.isEmpty()){
            stack2.push(stack1.peek());
            ans=stack1.peek();
            stack1.pop();
        }
        if(!stack2.isEmpty())
            stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }

        return ans;
    }
}
}
