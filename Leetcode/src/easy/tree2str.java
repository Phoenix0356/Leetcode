package easy;

import java.security.spec.RSAOtherPrimeInfo;

public class tree2str {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    StringBuilder sb=new StringBuilder();
    public String tree2str(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfs(root);
        return sb.toString().substring(1,sb.length()-1);
    }
    public void dfs(TreeNode root){
        sb.append("(");
        sb.append(root.val);
        if (root.left!=null){
            dfs(root.left);
        }else if (root.right!=null){
            sb.append("()");
        }
        if (root.right==null) dfs(root.right);;
        sb.append(")");
    }


}
