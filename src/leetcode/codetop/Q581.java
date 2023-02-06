package leetcode.codetop;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-02-06 9:04
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * 提示：
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 *          左段有序   中段无序   右段有序
 *          所以 中段里面的最小值 比 左段里面的最大值 还要大    即中段里面的所有值都比它大
 *              中段里面的最大值 比  右段里面的最小值 还要小   即中段里面的所有值都比它小
 *
 *          因此 从左到右  找最大值  这期间如果有值比最大值还要小 那么这个值就有可能是 中段的右边界
 *                 因为升序的时候（左右段） 最大值一直在替换，所以最后一个小  它就是 中段的右边界
 *          因此 从右到左  找最小值  这期间如果有值比最小值还要大 那么这个值就有可能是 中段的左边界
 *                 因为降序的时候（左右段） 最小值一直在替换，所以最后一个大 它就是 中段的左边界
 */
public class Q581 {
    @Leetcode("一次遍历")
    public int findUnsortedSubarray(int[] nums) {
        int leftmax=Integer.MIN_VALUE,rightmin=Integer.MAX_VALUE;
        int left=-1,right=-1,len=nums.length;
        for (int i = 0; i < len; i++) {
            if(leftmax>nums[i])
                right=i;//使right右边的值都比左边的值大,且有序
            else
                leftmax=nums[i];
            if(rightmin<nums[len-1-i])
                left=len-i-1;//left左边的值都是最小的,且有序
            else
                rightmin=nums[len-1-i];
        }
        return right==-1?0:right-left+1;
    }
}
