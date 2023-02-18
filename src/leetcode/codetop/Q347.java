package leetcode.codetop;

import leetcode.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lrd
 * @date 2023-02-17 19:10
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 */
public class Q347 {
    @Leetcode("优先队列")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());//大顶堆
        queue.addAll(map.entrySet());
        int[] ans = new int[k];
        for (int i = 0; i < k && !queue.isEmpty(); ++i){
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}
