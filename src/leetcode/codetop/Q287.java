package leetcode.codetop;

import leetcode.Leetcode;
import org.junit.Test;

/**
 * @author lrd
 * @date 2023-02-11 8:34
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * 示例 1：
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 提示：
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * Floyd 判圈算法   龟兔赛跑算法
 *先寻找一个不在环上的点为起点
 *先设置慢指针 slow 和快指针 fast，慢指针每次走一步，快指针每次走两步，
 * 根据「Floyd 判圈算法」两个指针在有环的情况下一定会相遇，
 * 此时我们再将 slow放置起点 0，两个指针每次同时移动一步，相遇的点就是答案。
 * 链接：https://leetcode.cn/problems/find-the-duplicate-number/solutions/261119/xun-zhao-zhong-fu-shu-by-leetcode-solution/
 * https://pic.leetcode-cn.com/970cf34694dd893c64924e1559617f64ad6b5b272a81ac3de5836cb6fb42fed7-image.png
 *
 * 在本题中选取0为起点,建立索引与数组位置的映射,模拟链表
 */
public class Q287 {
    @Leetcode("快慢指针")
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
