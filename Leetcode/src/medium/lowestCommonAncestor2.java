package medium;

import util.TreeNode;

import java.util.ArrayList;

public class lowestCommonAncestor2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        dfs(root,p.val,listP);
        dfs(root,q.val,listQ);
        TreeNode ans = null;
        int l = Math.min(listP.size(), listQ.size());
        for (int i = 0; i < l; i++) {
            if (listP.get(i) == listQ.get(i)){
                ans = listP.get(i);
            }
        }
        return ans;
    }

    void dfs(TreeNode node, int target ,ArrayList<TreeNode> list){
        if (node == null) return;
        list.add(node);
        if (target<node.val) dfs(node.left,target,list);
        else if(target>node.val) dfs(node.right, target, list);
    }
}
