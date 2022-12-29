package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

import java.util.Arrays;

/**
 * @author lrd
 * @date 2022-12-29 11:49
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 * 限制：
 * 1 <= n <= 11
 */
public class Offer60 {
@Leetcode("动态规划")
    public double[] dicesProbability(int n) {
        double ans[]=new double[6];
        Arrays.fill(ans,1.0/6.0);
        for (int i = 2; i <=n ; i++) {
            double []tmp=new double[5*i+1];//点数和[n-6n]
            for (int j = 0; j < ans.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j+k]+=ans[j]/6.0;
                    //k 0-6代表索引,第i个骰子对六个第i-1个骰子值的影响
                    //增加骰子的个数到i个时，i-1个骰子的第j个取值会对拥有i个骰子时的第j+k个取值产生影响
                }
            }
            ans=tmp;
        }
        return ans;
    }
}
