package leetcode.codetop;

import leetcode.Leetcode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-04-07 10:40
 * 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 示例 1：
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 * 提示：
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
 */
public class Q151 {
    @Leetcode("字符串")
    public String reverseWords(String s) {
        s=s.trim();
        if (s.equals(""))
            return s;
        int len= s.length();
        int l=0,r=0;
        StringBuilder sb=new StringBuilder();
        StringBuilder tmp=new StringBuilder();
        List<String> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)==' '){
                r=i;
                list.add(s.substring(l,r));
                tmp=new StringBuilder();
                tmp.append(" ");
                l=i+1;
            }
            else {
                list.add(tmp.toString());
                tmp=new StringBuilder();
                r++;
            }
        }
        if(r<=len)
            list.add(s.substring(l,len));
        for (int i = list.size()-1; i >=0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(reverseWords("EPY2giL"));
    }
}
