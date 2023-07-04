package leetcode.daimasuixianglu;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lrd
 * @date 2023-07-04 8:15
 */
public class Q347 {
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
