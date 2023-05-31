package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-05-31 8:25
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 示例 1：
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 * 提示：
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * 枚举出所有子串,然后判断
 */
public class Q647 {
    @Leetcode("中心扩散")
    public int countSubstrings1(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }
    @Leetcode("动态规划")
    public int countSubstrings(String s) {
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int ret=0;
        for(int i=n-1;i>=0;--i){
            for(int j=i;j<n;++j){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<=1||(i<=n-2&&j>=1)&&dp[i+1][j-1]){
                        ret++;
                        dp[i][j]=true;
                    }
                }
            }
        }
        return ret;
    }
}
