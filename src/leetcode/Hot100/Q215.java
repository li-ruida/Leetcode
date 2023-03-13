package leetcode.Hot100;

import leetcode.Leetcode;

import java.util.PriorityQueue;

/**
 * @author lrd
 * @date 2023-01-28 8:35
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Q215 {
    @Leetcode("快速排序")
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    public void quickSort(int []nums,int l,int r){
        if(l>=r)
            return;
        int i=l,j=r;
        while(i<j){
            while (i<j&&nums[j]>=nums[l])
                j--;
            while (i<j&&nums[i]<=nums[l])
                i++;
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        int tmp=nums[l];
        nums[l]=nums[i];
        nums[i]=tmp;
        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }
    @Leetcode("优先队列")
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
