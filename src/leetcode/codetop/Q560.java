package leetcode.codetop;

import leetcode.Leetcode;

import java.util.HashMap;

/**
 * @author lrd
 * @date 2023-02-19 9:07
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/247577/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
 * https://leetcode.cn/problems/subarray-sum-equals-k/solutions/238572/he-wei-kde-zi-shu-zu-by-leetcode-solution/
 * 满足 preSum - (preSum - k) == k 的区间的个数是我们所关心的
 */
public class Q560 {
    @Leetcode("前缀和 哈希表优化")
    public int subarraySum(int[] nums, int k) {
        int count=0,pre=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);//前缀和为0的次数为1次
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
