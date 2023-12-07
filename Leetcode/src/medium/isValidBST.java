package medium;

import util.TreeNode;

public class isValidBST {

    long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return dfs(root);
    }
    boolean dfs(TreeNode node){
        if (node == null) {
           return true;
        }
        boolean l=dfs(node.left);
        if (node.val<=pre) return false;
        pre= node.val;
        boolean r=dfs(node.right);
        return l&&r;
    }

}
