package easy;

import java.util.ArrayList;
import java.util.List;

public class preorder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
            List<Integer> ans = new ArrayList<>();
            public List<Integer> preorder(Node root) {
                dfs(root);
                return ans;
            }
            void dfs(Node root) {
                if (root == null) return ;
                ans.add(root.val);
                for (Node node : root.children) dfs(node);
            }
}
