package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-02 8:49
 *
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Q4 {
    @Leetcode("二分查找")
    //画分割线,使得左边元素的最大值与右边元素的最小值为所需值
    //保证分割线交叉顺序一致,即nums1[i-1]<=nums2[j] && nums1[i]>=nums2[j-1]
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            int []tmp=nums1;
            nums1=nums2;
            nums2=tmp;
        }//使得nums1为较短数组
        int m= nums1.length,n= nums2.length;
        int totalleft=(n+m+1)/2;//保证当为奇数个时,分割线左边上下数组的最大值为中位数
        int left=0,right=m;
        while (left<right){
            int i=left+(right-left+1)/2;//上面小数组的中间值
            int j=totalleft-i;//下面数组边界位置
            if(nums1[i-1]>nums2[j]){
                right=i-1;
            }
            else{
                left=i;
            }
        }
        int i=left,j=totalleft-left;
        //考虑分割线在边界特殊情况
        int nums1LeftMax=i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin=i==m?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax=j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin=j==n?Integer.MAX_VALUE:nums2[j];
        if((m+n)%2==1)
            return (double) Math.max(nums1LeftMax,nums2LeftMax);
        else
            return (double) (Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums2RightMin,nums1RightMin))/2;

    }
}
