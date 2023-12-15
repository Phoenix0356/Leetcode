package easy;

import java.util.LinkedList;
import java.util.Queue;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node=q.poll();
            if (node==null) break;
            if (node.left!=null&&node.right!=null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                q.offer(node.left);
                q.offer(node.right);
            }else if (node.left!=null){
                node.right=node.left;
                node.left=null;
                q.offer(node.right);
            }else if (node.right!=null){
                node.left=node.right;
                node.right=null;
                q.offer(node.left);
            }
        }
        return root;
    }
}
