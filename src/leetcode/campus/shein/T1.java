package leetcode.campus.shein;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-03-23 12:39
 * 无重复字符最长子数组
 */
public class T1 {
    public String[] lengthOfLongestSubstring(String s) {
        int left = 0,max = 0,right=0;
        List<String> ans=new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                left = Math.max(left,map.get(c) + 1);
                sb= new StringBuilder(s.substring(left, i+1));
            }
            else {
                sb.append(c);
            }
            right=i;
            map.put(c,i);
            if(right-left>=max){
                if(right-left>max){
                    ans.clear();
                    max=right-left;
                    ans.add(sb.toString());
                }else {
                    ans.add(sb.toString());
                }

            }

        }
        return ans.toArray(new String[0]);
    }
}
