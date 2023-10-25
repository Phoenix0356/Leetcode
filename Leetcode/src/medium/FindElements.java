package medium;

import util.TreeNode;

import java.util.HashSet;

public class FindElements {
    TreeNode root;
    HashSet<Integer> set;
    public FindElements(TreeNode root) {
        this.set=new HashSet<>();
        this.root=root;
        recover(root,0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
    void recover(TreeNode node,int val){
        if (node==null) return ;
        node.val=val;
        set.add(val);
        recover(node.left,val<<2+1);
        recover(node.right,val<<2+2);

    }

}
