package medium;

import util.Node;
import util.TreeNode;

public class flatten {
    public void flatten(TreeNode root) {
        dfs(root);

    }
    void dfs(TreeNode node){
        if (node == null) return;



        dfs(node.left);
        dfs(node.right);

        TreeNode left = node.left;
        TreeNode right = node.right;

        node.left = null;
        node.right = left;
        TreeNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;


    }



}
