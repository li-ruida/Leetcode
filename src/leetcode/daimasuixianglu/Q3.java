package leetcode.daimasuixianglu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-08-26 9:52
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
        int len=s.length();
        if(len==0)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        int l=0,r=0,ansl=0,ansr=0,max=0;
        for(int i=0;i<len;i++){
            if(map.get(s.charAt(i))!=null){
                l=Math.max(map.get(s.charAt(i))+1,l);
            }
            r=i;
            map.put(s.charAt(i),i);
            if(r-l+1>=max){
                ansl=l;
                ansr=r;
                max=r-l+1;
            }
        }

        return max;
    }
}
