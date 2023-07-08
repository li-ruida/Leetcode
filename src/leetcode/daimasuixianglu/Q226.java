package leetcode.daimasuixianglu;

import leetcode.Leetcode;

import java.util.ArrayDeque;

/**
 * @author lrd
 * @date 2023-07-08 19:43
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class Q226 {
    @Leetcode("递归")
    public TreeNode invertTree1(TreeNode root){
        if (root==null)
            return null;
        TreeNode l=invertTree(root.left);
        TreeNode r=invertTree(root.right);
        root.left=r;
        root.right=l;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null)
                    deque.offer(node.left);
                if (node.right != null)
                    deque.offer(node.right);
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
