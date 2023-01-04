package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

/**
 * @author lrd
 * @date 2023-01-04 9:25
 *
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 左指针左边均为非零数
 * 右指针左边直到左指针处均为零
 * 每次交换都是将左指针的零与右指针的非零数交换
 */
public class Q283 {
    @Leetcode("双指针")
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                nums[left++]=nums[right];
            }
            right++;
        }
        for (int i = left; i < n; i++) {
            nums[i]=0;
        }
    }


}
