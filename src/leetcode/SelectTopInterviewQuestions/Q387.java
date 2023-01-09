package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author lrd
 * @date 2023-01-09 10:16
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 * 提示:
 * 1 <= s.length <= 105
 * s 只包含小写字母
 */
public class Q387 {
    @Leetcode("HashMap")
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char[] c=s.toCharArray();
        int len=c.length;
        int ans=len;
        for (int i = 0; i < len; i++) {
            if(map.get(c[i])==null){
                map.put(c[i],i);
            }
            else{
                map.put(c[i],len);
            }
        }
        Set set = map.keySet();
        Iterator iter= set.iterator();
        while (iter.hasNext()){
            Object key=iter.next();
            Object value=map.get(key);
            ans=Math.min(ans,(int)value);
        }
        return ans==len?-1:ans;
    }
}
