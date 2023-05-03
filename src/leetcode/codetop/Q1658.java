package leetcode.codetop;

import leetcode.Leetcode;

import java.util.Arrays;

/**
 * @author lrd
 * @date 2023-05-03 9:18
 * 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，
 * 然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * 示例 1：
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 */
public class Q1658 {
    @Leetcode("滑动窗口")
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }
        int right = 0;
        int lsum = 0, rsum = sum;
        int ans = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }

        return ans > n ? -1 : ans;
    }
    @Leetcode("双指针 逆向思维")
    public int minOperations1(int[] nums, int x) {
        int target = -x;
        for (int num : nums)
            target += num;
        if (target < 0)
            return -1; // 全部移除也无法满足要求
        int ans = -1, left = 0, sum = 0, n = nums.length;
        for (int right = 0; right < n; ++right) {
            sum += nums[right];
            while (sum > target)
                sum -= nums[left++]; // 缩小子数组长度
            if (sum == target)
                ans = Math.max(ans, right - left + 1);
        }
        return ans < 0 ? -1 : n - ans;
    }

}
