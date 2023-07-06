package leetcode.daimasuixianglu;

import leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lrd
 * @date 2023-07-03 7:58
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Q239 {
    @Leetcode("单调队列")
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
        }
        int []ans=new int[n-k+1];
        ans[0]=nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            while (deque.peekFirst()<=i-k){
                deque.pollFirst();//清除失效的值
            }
            ans[i-k+1]=nums[deque.peekFirst()];
        }
        return ans;
    }
}