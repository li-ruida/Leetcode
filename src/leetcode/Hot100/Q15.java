package leetcode.Hot100;

import leetcode.Leetcode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lrd
 * @date 2023-01-25 10:03
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Q15 {
    @Leetcode("快速排序+双指针")
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        int len=nums.length-1;
        quickSort(nums,0,len);
        for (int k=0;k<nums.length - 2;k++) {
            if (nums[k]>0)
                break;
            if(k>0 && nums[k]==nums[k-1])
                continue;
            int i=k+1,j=len;
            while (i<j){
                int sum =nums[i]+nums[j]+nums[k];
                if (sum<0){
                    while (i<j&&nums[i]==nums[++i]);//找到第一个大于的
                }else if(sum>0){
                    while (i<j&&nums[j]==nums[--j]);
                }
                else{
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);

                }
            }
        }

        return ans;
    }
    /*
从右开始找到第一个比基准值小的元素
从左开始找到第一个比基准值大的元素
直到左右遍历到同一个位置,即为基准值的正确的位置
然后开始分治递归
 */
    public void quickSort(int []nums,int l,int r){
        if(l>=r)
            return;
        int i=l,j=r;
        while (i<j){
            while (i<j && nums[j]>=nums[l])
                j--;
            while (i<j && nums[i]<=nums[l])
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
    @Test
    public void test(){

        int []nums=new int[]{3,0,-2,-1,1,2};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        //System.out.println(threeSum(nums));
    }
}
