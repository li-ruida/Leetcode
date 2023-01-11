package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lrd
 * @date 2023-01-11 10:21
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class Q169 {
    @Leetcode("HashMap")
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int count=map.getOrDefault(num,0);
            map.put(num,count+1);
        }
        int ans=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/2){
                ans=entry.getKey();
                break;
            }
        }
        return ans;
    }
}
