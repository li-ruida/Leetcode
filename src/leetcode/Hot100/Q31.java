package leetcode.Hot100;

import leetcode.Leetcode;
import org.junit.Test;

/**
 * @author lrd
 * @date 2023-01-25 21:46
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，
 * 那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Q31 {
    @Leetcode("两遍扫描")
    public void nextPermutation(int[] nums) {
        int tail=nums.length-1;
        while (tail-1>=0&&nums[tail-1]>=nums[tail])
            tail--;
        tail--;//从尾扫描第一个非逆序
        if(tail>=0){//如果不是头节点,头节点直接逆序
            int t=nums.length-1;
            while (t>=0&& nums[tail]>=nums[t])
                t--;//找到第一个比tail大的元素
            swap(nums,t,tail);
        }
        reverse(nums,tail+1);
    }
    public void swap(int []nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public void reverse(int num[],int start){
        int l=start,r=num.length-1;
        while (l<r){
            swap(num,l,r);
            l++;
            r--;
        }
    }
    @Test
    public void test(){
        int []nums=new int[]{1,2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }
}
