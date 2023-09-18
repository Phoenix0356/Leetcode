package medium;

import util.TreeNode;

public class lowestCommonAncestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val ,q.val,0);
        return ans;
    }
    int dfs(TreeNode node,int targetQ,int targetP,int cnt){
        if (node==null) return 0;
        int cnt1=dfs(node.left,targetQ,targetP,cnt);
        int cnt2=dfs(node.right, targetQ, targetP,cnt);
        if (node.val==targetP||node.val==targetQ) ++cnt;
        if (cnt1+cnt2+cnt==2) {
            ans=node;
            return 0;
        }
        return cnt1+cnt2+cnt;
    }
}
