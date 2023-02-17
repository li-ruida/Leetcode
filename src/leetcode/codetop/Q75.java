package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-02-17 8:09
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 */
public class Q75 {
    @Leetcode("双指针")
    public void sortColors(int[] nums) {
        int n=nums.length;
        int p0=0,p2=n-1;
        for (int i = 0; i <= p2; i++) {
            while (i<=p2&&nums[i]==2){//考虑到nums[p2]本身为2,与第一个p2不为2的交换
                nums[i]=nums[p2];
                nums[p2]=2;
                --p2;
            }
            if(nums[i]==0){
                nums[i]=nums[p0];
                nums[p0]=0;
                ++p0;
            }
        }
    }
}
