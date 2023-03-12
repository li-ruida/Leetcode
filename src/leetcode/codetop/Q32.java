package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lrd
 * @date 2023-03-12 9:30
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 * 提示：
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class Q32 {
    @Leetcode("栈")
    //保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
    Deque<Integer> stack=new ArrayDeque<>();
    public int longestValidParentheses1(String s) {
        int ans=0,n=s.length();
        if(n==0){
            return 0;
        }
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    ans=Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }
    @Leetcode("动态规划")
    public int longestValidParentheses(String s) {
        int ans=0;
        int []dp=new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;//()()()()
                } else if (i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='(') {
                    dp[i]=dp[i-1]+((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;//()((()))
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}
