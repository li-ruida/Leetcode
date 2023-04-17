package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-04-17 18:08
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * 输出：3
 * 解释：长度最长的公共子数组是 [3,2,1] 。
 * 示例 2：
 * 输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * 输出：5
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
public class Q718 {
    @Leetcode("动态规划")
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        int ans=0;
        int [][]dp=new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j]=nums1[i-1]==nums2[j-1]?dp[i-1][j-1]+1:0;
                ans=Math.max(ans,dp[i][j]);
            }
        }

        return ans;
    }
}
