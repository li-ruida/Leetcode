package leetcode.SelectTopInterviewQuestions;

import java.util.HashMap;

/**
 * @author lrd
 * @date 2023-01-01 11:09
 *
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        char []c=s.toCharArray();
        int len=c.length;
        if(len==0)
            return 0;
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0,r=0,max=0;
        for (int i = 0; i < len; i++) {
            if(map.get(c[i])==null||map.get(c[i])<l){
                r=i;
            } else{
                l=map.get(c[i])+1;
            }
            map.put(c[i],i);
            max=Math.max(max,r-l);
        }
        return max+1;
    }
}
