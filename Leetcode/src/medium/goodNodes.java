package medium;

import util.TreeNode;

public class goodNodes {
    int max=0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return max;
    }
    void dfs(TreeNode next,int maxValue){
        if (maxValue>next.val) next.val=maxValue;
        else max++;
        if (next.left!=null) dfs(next.left,next.val);
        if (next.right!=null) dfs(next.right,next.val);
    }
}
