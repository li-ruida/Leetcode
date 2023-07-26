package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-07-26 9:24
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Q17 {
    List<String> list;
    Map<Character,String> map;
    public List<String> letterCombinations(String digits) {
        list=new ArrayList<>();
        if(digits.length()==0)
            return list;
        map=new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(digits,0,new StringBuffer());
        return list;
    }
    public void dfs(String digits,int index, StringBuffer sb){
        if(index==digits.length()){
            list.add(sb.toString());
        }else {
            char ch=digits.charAt(index);
            String letters=map.get(ch);
            int len=letters.length();
            for (int i = 0; i < len; i++) {
                sb.append(letters.charAt(i));
                dfs(digits,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
