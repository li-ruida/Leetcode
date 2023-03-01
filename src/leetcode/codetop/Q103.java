package leetcode.codetop;

import java.util.*;

/**
 * @author lrd
 * @date 2023-03-01 16:23
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class Q103 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> nodeQueue=new ArrayDeque<>();
        nodeQueue.offer(root);
        boolean leftFlag=true;
        while (!nodeQueue.isEmpty()){
            Deque<Integer> list=new LinkedList<>();
            int size=nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur=nodeQueue.poll();
                if(leftFlag)
                    list.offerLast(cur.val);
                else
                    list.offerFirst(cur.val);
                if(cur.left!=null)
                    nodeQueue.offer(cur.left);
                if(cur.right!=null)
                    nodeQueue.offer(cur.right);
            }
            ans.add(new LinkedList<Integer>(list));
            leftFlag=!leftFlag;
        }
        return ans;
    }
}
