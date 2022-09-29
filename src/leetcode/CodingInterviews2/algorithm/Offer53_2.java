package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-09-13 下午4:58
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 限制：
 * 1 <= 数组长度 <= 10000
 */
public class Offer53_2 {
/*
位运算
执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：41.5 MB, 在所有 Java 提交中击败了99.67%的用户
 */
@Leetcode("位运算异或")
    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            ans ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {//<=注意比length多一个数
            ans ^= i;
        }
        return ans;
    }
/*
求和
HashSet
 */
}
