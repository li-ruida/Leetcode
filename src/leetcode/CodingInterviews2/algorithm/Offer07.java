package leetcode.CodingInterviews2.algorithm;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author lrd
 * @date 2022-09-04 上午11:14
 * 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Offer07 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/*TODO:递归
执行用时：1 ms, 在所有 Java 提交中击败了99.83%的用户
内存消耗：41.1 MB, 在所有 Java 提交中击败了54.15%的用户
 */
  HashMap<Integer,Integer> map=new HashMap<>();//存储中序遍历的值和索引
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      int n=inorder.length;
      for (int i =0;i<n;i++) {
        map.put(inorder[i],i);
      }
      return myTree(preorder,inorder,0,n-1,0,n-1);
    }
  public TreeNode myTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){

    int n=preorder.length;
    if(preorder_left>preorder_right)
      return null;
    int preorderroot=preorder_left;//根节点前序索引
    int inorderroot=map.get(preorder[preorderroot]);//根节点后序索引
    TreeNode root=new TreeNode(preorder[preorderroot]);
    int temp=inorderroot-inorder_left;//左子树节点数
    root.left=myTree(preorder,inorder,preorder_left+1,preorder_left+temp,inorder_left,inorderroot-1);
    root.right=myTree(preorder,inorder,preorder_left+temp+1,preorder_right,inorderroot+1,inorder_right);

    return root;
  }

/*
TODO:迭代
任意两个连续节点 u 和 v，根据前序遍历的流程，我们可以知道 u 和 v 只有两种可能的关系：
v 是 u 的左儿子。这是因为在遍历到 uu 之后，下一个遍历的节点就是 u 的左儿子，即 v；
u 没有左儿子，并且 v 是 u 的某个祖先节点（或者 u 本身）的右儿子。如果 u 没有左儿子，那么下一个遍历的节点就是 u 的右儿子。
如果 u 没有右儿子，我们就会向上回溯，直到遇到第一个有右儿子（且 u 不在它的右儿子的子树中）的节点 u_au
 ，那么 v 就是 u_au的右儿子。
作者：LeetCode-Solution
链接：https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-by-leetcode-s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public TreeNode buildTree1(int[] preorder, int[] inorder) {
  if (preorder == null || preorder.length == 0) {
    return null;
  }
  TreeNode root = new TreeNode(preorder[0]);
  Deque<TreeNode> stack = new LinkedList<TreeNode>();
  stack.push(root);
  int inorderIndex = 0;
  for (int i = 1; i < preorder.length; i++) {
    int preorderVal = preorder[i];
    TreeNode node = stack.peek();
    if (node.val != inorder[inorderIndex]) {
      node.left = new TreeNode(preorderVal);
      stack.push(node.left);
    } else {
      while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
        node = stack.pop();
        inorderIndex++;
      }
      node.right = new TreeNode(preorderVal);
      stack.push(node.right);
    }
  }
  return root;
}

}
