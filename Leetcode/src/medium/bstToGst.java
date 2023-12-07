package medium;

import util.TreeNode;

public class bstToGst {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if (root!=null) {
            bstToGst(root.right);
            root.val += sum;
            sum = root.val;
            bstToGst(root.left);
        }
        return root;
    }
}
