package leetcode.daimasuixianglu;

/**
 * @author lrd
 * @date 2023-06-26 7:24
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
public class Offer05 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ')
                res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
