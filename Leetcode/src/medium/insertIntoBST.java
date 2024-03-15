package medium;

import util.TreeNode;

public class insertIntoBST {
    int val;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        this.val = val;
        if(root==null) return new TreeNode(val);
        dfs(root);
        return root;
    }

    TreeNode dfs(TreeNode root){
        if(root == null){
            return null;
        }

        if (root.val<val) {
            TreeNode right= dfs(root.right);
            if (right == null) root.right = new TreeNode(val);
        }
        else {
            TreeNode left = dfs(root.left);
            if(left == null) root.left = new TreeNode(val);
        }

        return root;

    }
}
