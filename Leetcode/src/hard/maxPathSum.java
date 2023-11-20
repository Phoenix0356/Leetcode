package hard;

import util.TreeNode;

public class maxPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;

    }
    int dfs(TreeNode node){
        if (node==null) return 0;
        int cur = node.val, left = Math.max(dfs(node.left),0), right = Math.max(dfs(node.right),0);
        cur = Math.max(cur + left, cur);
        cur = Math.max(cur + right, cur);
        max = Math.max(cur, max);
        return node.val+Math.max(left,right);
    }
}
