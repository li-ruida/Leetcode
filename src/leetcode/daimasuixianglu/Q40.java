package leetcode.daimasuixianglu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lrd
 * @date 2023-07-28 9:30
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Q40 {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> tmp=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return ans;
    }
    public void dfs(int[] candidates, int target,int index){
        if (target==sum){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < candidates.length&&sum+candidates[i]<=target; i++) {//剪枝
            if(i>index&&candidates[i]==candidates[i-1]){//去重
                continue;
            }
            tmp.add(candidates[i]);
            sum+=candidates[i];
            dfs(candidates,target,i+1);
            sum-=candidates[i];
            tmp.remove(tmp.size()-1);
        }
    }
}
