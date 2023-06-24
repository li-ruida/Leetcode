package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lrd
 * @date 2023-06-24 0:39
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
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
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        int len= nums.length;
        Arrays.sort(nums);
        for(int k=0;k<len-2;k++){
            if(nums[k]>0)
                break;
            if(k>0&&nums[k]==nums[k-1])
                continue;
            int i=k+1,j=len-1;
            while (i<j){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    while (i<j&&nums[i]==nums[++i]);
                } else if (sum>0) {
                    while (i<j&&nums[j]==nums[--j]);
                }else {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    while (i<j&&nums[i]==nums[++i]);
                    while (i<j&&nums[j]==nums[--j]);
                }
            }
        }
        return ans;
    }
}
