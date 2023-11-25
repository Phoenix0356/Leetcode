package medium;
import util.TreeNode;

import java.util.HashSet;

public class pseudoPalindromicPaths {
    int cnt=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,new HashSet<Integer>());
        return cnt/2;

    }
    void dfs(TreeNode node,HashSet<Integer> set){
        boolean flag=false;
        if (set.contains(node.val)) set.remove(node.val);
        else set.add(node.val);
        HashSet<Integer> left=new HashSet<>(set);
        HashSet<Integer> right=new HashSet<>(set);

        if (node.left!=null){
            flag=true;
            dfs(node.left, left);
        }
        if (node.right!=null){
            flag=true;
            dfs(node.right, right);
        }
        if (!flag){
            if (set.size()<=1) cnt++;
        }

    }
}
