package leetcode.daimasuixianglu;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author lrd
 * @date 2023-07-14 9:19
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 提示:
 * 二叉树的节点个数的范围是 [1,104]
 * -231 <= Node.val <= 231 - 1
 */
public class Q513 {
    public int findBottomLeftValue(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p.right != null) {
                queue.offer(p.right);
            }
            if (p.left != null) {
                queue.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }
}
