package leetcode.daimasuixianglu;

import leetcode.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lrd
 * @date 2023-07-29 13:34
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。
 * 返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Q131 {
    @Leetcode("记忆化搜索")
    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int len;

    public List<List<String>> partition(String s) {
        len = s.length();
        f = new int[len][len];
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == len) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < len; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
