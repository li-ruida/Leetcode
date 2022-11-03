package leetcode.CodingInterviews2.algorithm;

/**
 * @author lrd
 * @date 2022-09-15 上午8:58
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * 提示：
 * 0 <= nums.length <= 50000
 * 0 <= nums[i] <= 10000
 */
public class Offer21 {
/*
暴力
执行用时：2 ms, 在所有 Java 提交中击败了41.36%的用户
内存消耗：49.3 MB, 在所有 Java 提交中击败了49.93%的用户
 */
@Leetcode("暴力")
    public int[] exchange1(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2==1)
                ans[count++]=nums[i];
        }
        for(int i=0;i<n;i++){
            if(nums[i]%2==0)
                ans[count++]=nums[i];
        }
        return ans;
    }
/*
双指针
执行用时：2 ms, 在所有 Java 提交中击败了41.36%的用户
内存消耗：49.2 MB, 在所有 Java 提交中击败了58.42%的用户
 */
@Leetcode("双指针")
    public int[] exchange(int[] nums) {
    int i = 0, j = nums.length - 1, tmp;
    while(i < j) {
        while(i < j && (nums[i] & 1) == 1)
            i++;//找到第一个偶数
        while(i < j && (nums[j] & 1) == 0)
            j--;//找到最后一个奇数
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    return nums;
    }
}
