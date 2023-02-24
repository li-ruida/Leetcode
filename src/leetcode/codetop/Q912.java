package leetcode.codetop;

import leetcode.Leetcode;
import org.junit.Test;

import java.util.Random;

/**
 * @author lrd
 * @date 2023-02-24 10:06
 * 912. 排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * 提示：
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class Q912 {
    @Leetcode("快速排序 优化")
    private static final Random random = new Random();
    public int[] sortArray1(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        //递归退出条件
        if (left >= right) {
            return;
        }
        //随机选取法
        int RandomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, RandomIndex);

        int pivot = nums[left];
        int less = left;
        int more = right + 1;
        // 循环不变量：这里是左闭右闭区间
        // 小于nums[pivot]区间：[left + 1, less]
        // 等于nums[pivot]区间：[less + 1, i]
        // 大于nums[pivot]区间：[more, right]
        int i = left + 1;
        while (i < more) {
            if (nums[i] < pivot) {
                less++;
                swap(nums, i, less);
                i++;
            } else if (nums[i] == pivot) {
                i++;
            } else {
                //这里不i++很重要！因为我们无法确定从尾部换来的元素是否小于nums[pivot]
                more--;
                swap(nums, i, more);
            }
        }
        //less最后指向的一定是小于nums[pivot]的元素
        swap(nums, left, less);
        //同理more指向大于nums[pivot]的元素
        quickSort(nums, left, less - 1);
        quickSort(nums, more, right);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Leetcode("归并排序")
    int[] tmp;
    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }

}
