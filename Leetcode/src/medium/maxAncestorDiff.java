package medium;

import util.TreeNode;

public class maxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    int dfs(TreeNode node,int min, int max){
        max=Math.max(node.val,max);
        min=Math.min(node.val,min);
        int cur=max-min;
        if (node.left!=null) cur=Math.max(dfs(node.left,min,max),cur);
        if (node.right!=null) cur=Math.max(dfs(node.right,min,max),cur);
        return cur;
    }
}
