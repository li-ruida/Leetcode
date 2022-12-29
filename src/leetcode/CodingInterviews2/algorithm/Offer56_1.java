package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2022-12-23 10:28
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * 限制：
 * 2 <= nums.length <= 10000
 *
 * 先遍历异或一遍,最后结果为a^b找结果二进制位位1的一项进行分组(二进制位为1,代表两数此位不同)
 */
public class Offer56_1 {
@Leetcode("数学")
    public int[] singleNumbers(int[] nums) {
        int ans=0;
        int m=1;
        int a=0,b=0;
        for (int i = 0; i < nums.length; i++) {
            ans^=nums[i];
        }
        while ((m&ans)==0){
            m<<=1;
        }
    for (int i = 0; i < nums.length; i++) {
        if((nums[i]&m)==0){
            a^=nums[i];
        }
        else {
            b^=nums[i];
        }
    }


        return new int[]{a, b};
    }
}
