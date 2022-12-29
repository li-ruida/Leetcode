package leetcode.CodingInterviews2.algorithm;

import leetcode.Leetcode;

import java.util.*;

/**
 * @author lrd
 * @date 2022-09-27 上午7:44
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 提示：
 *
 * 节点总数 <= 1000
 */
public class Offer32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
/*BFS
执行用时：1 ms, 在所有 Java 提交中击败了96.14%的用户
内存消耗：41.6 MB, 在所有 Java 提交中击败了47.33%的用户
 */
@Leetcode("BFS")
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        boolean flag=true;//标记添加方向
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                if (!flag){
                    level.offerFirst(node.val);
                }
                else {
                    level.offerLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(new LinkedList<Integer>(level));//强转
            flag=!flag;
        }

        return ans;





    }

}
