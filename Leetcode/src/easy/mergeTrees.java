package easy;

public class mergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null&&root2==null) return null;
        TreeNode newRoot=new TreeNode();
        merge(root1,root2,newRoot);
        return newRoot;

    }
    void merge(TreeNode root1,TreeNode root2,TreeNode newRoot){
        if (root1!=null&&root2!=null){
            newRoot.val=root1.val+root2.val;
            if (root1.left!=null||root2.left!=null){
                newRoot.left=new TreeNode();
                merge(root1.left,root2.left,newRoot.left);
            }
            if (root1.right!=null||root2.right!=null){
                newRoot.right=new TreeNode();
                merge(root1.right,root2.right,newRoot.right);
            }
        }else if (root2!=null) {
            newRoot.val= root2.val;
            if (root2.left!=null){
                newRoot.left=new TreeNode();
                merge(null,root2.left,newRoot.left);
            }
            if (root2.right!=null){
                newRoot.right=new TreeNode();
                merge(null,root2.right,newRoot.right);
            }
        }
        else if (root1!=null) {
            newRoot.val=root1.val;
            if (root1.left!=null){
                newRoot.left=new TreeNode();
                merge(root1.left,null,newRoot.left);
            }
            if (root1.right!=null){
                newRoot.right=new TreeNode();
                merge(root1.right,null,newRoot.right);
            }
        }
    }
}
