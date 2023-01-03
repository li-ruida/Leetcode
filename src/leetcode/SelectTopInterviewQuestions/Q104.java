package leetcode.SelectTopInterviewQuestions;

import leetcode.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lrd
 * @date 2023-01-03 11:07
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class Q104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    @Leetcode("DFS")
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        else{
            int lefth=maxDepth(root.left);
            int righth=maxDepth(root.right);
            return Math.max(lefth,righth)+1;
        }
    }
    @Leetcode("BFS")
    public int maxDepth1(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        int ans=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();//把每一层全部元素取出,层数加一,放入新的一层儿子元素
            while (size>0){
                TreeNode node=queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;
    }
}
