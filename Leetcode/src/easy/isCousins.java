package easy;

public class isCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        return isBrother(root,x,0) == isBrother(root,y,0)&&isParent(root, x, y);
    }
    int isBrother(TreeNode node, int tar,int cur){
        if (node == null) return 0;
        if (tar == node.val) return cur;
        int leftDepth = isBrother(node.left,tar,cur+1);
        int rightDepth = isBrother(node.right,tar, cur+1);
        return Math.max(leftDepth,rightDepth);
    }
    boolean isParent(TreeNode node,int x,int y){
        if (node == null) return true;
        if (node.left == null) return isParent(node.right,x,y);
        if (node.right == null) return isParent(node.left, x, y);
        if (node.left.val == x){
            return node.right.val != y;
        }
        if (node.left.val == y){
            return node.right.val != x;
        }
        return isParent(node.left,x,y)&&isParent(node.right,x,y);
    }
}
