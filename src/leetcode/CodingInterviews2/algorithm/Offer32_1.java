package leetcode.CodingInterviews2.algorithm;

import java.util.*;

/**
 * @author lrd
 * @date 2022-09-25 上午7:48
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * [3,9,20,15,7]
 * 提示：
 * 节点总数 <= 1000
 */
public class Offer32_1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
/*BFS
执行用时1 ms, 在所有 Java 提交中击败了97.96%的用户
内存消耗：41.3 MB, 在所有 Java 提交中击败了67.23%的用户
 */
@Leetcode("BFS")
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];//与null不同
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}














