package leetcode.CodingInterviews2.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lrd
 * @date 2022-09-26 上午7:19
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 提示：
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Offer32_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
/*BFS
执行用时：1 ms, 在所有 Java 提交中击败了70.34%的用户
内存消耗：41.7 MB, 在所有 Java 提交中击败了31.10%的用户
 */
@Leetcode("BFS")
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(level);
        }

        return ans;





    }
}





























