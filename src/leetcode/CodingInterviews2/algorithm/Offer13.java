package leetcode.CodingInterviews2.algorithm;

import org.junit.Test;

/**
 * @author lrd
 * @date 2022-12-27 10:33
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * 数位和增量公式 本题说明 1≤n,m≤100 ，公式仅在此范围适用
 * (x + 1) % 10 != 0 ? s_x + 1 : s_x - 8;
 * 通用:
 *     int mySum(int a){
 *         int ans=0;
 *         while (a>0){
 *             ans+=a%10;
 *             a/=10;
 *         }
 *         return ans;
 *     }
 */
public class Offer13 {
@Leetcode("DFS")
    int mm,nn,kk;
    boolean visit[][];
    public int movingCount(int m, int n, int k) {
        mm=m;
        nn=n;
        kk=k;
        visit=new boolean[m][n];
        return dfs(0,0);
    }
    int dfs(int i,int j){
        if(i>=mm||j>=nn||mySum(i)+mySum(j)>kk||visit[i][j])
            return 0;
        visit[i][j]=true;
        return 1+dfs(i+1,j)+dfs(i,j+1);
    }
    int mySum(int a){
        int ans=0;
        while (a>0){
            ans+=a%10;
            a/=10;
        }
        return ans;
    }


}
