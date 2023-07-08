package leetcode.daimasuixianglu;

import java.util.List;

/**
 * @author lrd
 * @date 2023-07-08 12:39
 */
public class Node {

        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

}
