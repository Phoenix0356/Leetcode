package medium;

import util.TreeNode;

public class kthSmallest {
    int order;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        order = k;
        ans = 0;
        dfs(root);
        return ans;
    }
    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        order--;
        if(order == 0){
            ans = root.val;
        }
        dfs(root.right);

    }
}
