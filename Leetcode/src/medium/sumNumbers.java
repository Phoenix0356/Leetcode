package medium;

import util.TreeNode;

public class sumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    int dfs(TreeNode node,int pre){
        if (node==null) return 0;
        int curVal=pre*10+ node.val;
        int leftSum=dfs(node.left,curVal);
        int rightSum=dfs(node.right,curVal);
        int sum=leftSum+rightSum;
        return sum==0?curVal:sum;
    }
}
