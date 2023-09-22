package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class delNodes {
    ArrayList<TreeNode> list=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set=new HashSet<>();
        for (int n:to_delete) set.add(n);
        root=dfs(root,set,set.contains(root.val));
        if (root!=null) list.add(root);
        return list;
    }
    TreeNode dfs(TreeNode node,HashSet<Integer> set,boolean isDeleted){
        if (node==null) return null;
        if (set.contains(node.val)){
            node.left=dfs(node.left,set,true);
            node.right=dfs(node.right,set,true);
            return null;
        }else {
            if (isDeleted)  list.add(node);
            node.left=dfs(node.left,set,false);
            node.right=dfs(node.right,set,false);

        }
        return node;
    }
}
