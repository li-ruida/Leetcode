package leetcode.daimasuixianglu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lrd
 * @date 2023-07-08 19:40
 * 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
 * 则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 提示：
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 */
public class Q117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        if (root==null)
            return null;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            Node node=null;
            Node pre=null;
            for (int i = 0; i < size; i++) {
                node=queue.poll();
                if (i==0)
                    pre=node;
                else {
                    pre.next=node;
                    pre=pre.next;
                }
                if (node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return root;
    }
}
