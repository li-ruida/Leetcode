package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

import java.util.HashMap;

/**
 * @author lrd
 * @date 2022-12-31 10:07
 *
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * s.length <= 40000
 * 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Offer48 {
@Leetcode("动态规划")
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char []c=s.toCharArray();
        int len=c.length;
        if (len==0)
            return 0;
        int l=0,r=0,max=0;
        for (int i = 0; i < len; i++) {
            if(map.get(c[i])==null||map.get(c[i])<l){
                r=i;
            }
            else {
                l=map.get(c[i])+1;
                r=i;
            }
            map.put(c[i],i);
            max=Math.max(max,r-l);
        }
        return max+1;
    }
}
