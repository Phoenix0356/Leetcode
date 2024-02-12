package easy;

import java.util.ArrayList;
import java.util.List;

public class postorderTraversal {
    List<Integer> solution = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return solution;
    }
    public void dfs(TreeNode node){
        if (node == null) return;
        dfs(node.left);
        dfs(node.right);
        solution.add(node.val);
    }
}
