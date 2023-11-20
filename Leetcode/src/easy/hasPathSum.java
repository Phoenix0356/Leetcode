package easy;

public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null) return false;
        int res = targetSum - root.val;
        if (root.left==null&&root.right==null) return res==0;
        return hasPathSum(root.left,res)||hasPathSum(root.right,res);
    }
}
