package leetcode.CodingInterviews2.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lrd
 * @date 2022-11-07 下午7:58
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 */
public class Offer50 {
@Leetcode("hashmap")
    public char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }


}
