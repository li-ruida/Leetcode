package leetcode.codetop;

import leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author lrd
 * @date 2023-05-04 12:25
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 提示：
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 */



public class Q230 {
//    class TreeNode {
//        int val;
//        leetcode.codetop.TreeNode left;
//        leetcode.codetop.TreeNode right;
//        TreeNode() {}
//        TreeNode(int val) { this.val = val; }
//        TreeNode(int val, leetcode.codetop.TreeNode left, leetcode.codetop.TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
    @Leetcode("中序遍历")
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> d = new ArrayDeque<>();
        while (root != null || !d.isEmpty()) {
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }
            root = d.pollLast();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1; // never
    }
    public int kthSmallest1(TreeNode root, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)->b-a);
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode node = d.pollFirst();
            if (q.size() < k) {
                q.add(node.val);
            } else if (q.peek() > node.val) {
                q.poll();
                q.add(node.val);
            }
            if (node.left != null) d.addLast(node.left);
            if (node.right != null) d.addLast(node.right);
        }
        return q.peek();
    }
}
