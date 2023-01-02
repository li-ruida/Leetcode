package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lrd
 * @date 2023-01-02 11:10
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Q20 {
    @Leetcode("栈")
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        char []c=s.toCharArray();
        char t;
        for (char tmp:c) {
            if(tmp=='('||tmp=='{'||tmp=='[')
                stack.push(tmp);
            else {
                if(!stack.isEmpty()){
                    t=stack.peek();
                }
                else{
                    return false;
                }
                if(t=='('&&tmp==')'||t=='['&&tmp==']'||t=='{'&&tmp=='}')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
