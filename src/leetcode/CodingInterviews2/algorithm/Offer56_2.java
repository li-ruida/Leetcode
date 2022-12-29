package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2022-12-23 18:19
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 */
public class Offer56_2 {
@Leetcode("数学")
    public int singleNumber(int[] nums) {
        int count[]=new int[32];
        for (int num:nums){
            for (int i = 0; i < 32; i++) {
                count[i]+=num&1;
                num>>>=1;//无符号右移,高位补0
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % 3;
        }
        return res;
    }
}
