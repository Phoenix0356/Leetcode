package easy;

public class findTarget {


    public boolean findTarget(TreeNode root, int k) {
        TreeNode node=root;
        while (node!=null) {
            if (node.right!=null){
                if (dfs(k, node.val,root) == true) return true;
                node=root.right;
            }
            if (node.left==null){
                if (dfs(k, node.val,root) == true) return true;
                node=root.left;
            }

        }
        return false;
    }
    boolean dfs(int k,int cur,TreeNode node){
        if (node==null)return false;
        if (node.right==null&&node.left==null){
            if (node.val+cur<k)return false;
        }
        if (k-cur==node.val) {
            return true;
        } else if (node.right!=null){
            if (dfs(k,cur,node.right)==true) {
                return true;
            }
        }
        if (node.left!=null){
            if (dfs(k,cur,node.left)==true){
                return true;
            }
        }
        return false;
    }
}
