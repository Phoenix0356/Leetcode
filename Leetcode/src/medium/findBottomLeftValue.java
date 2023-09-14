package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class findBottomLeftValue {
    int height=-1,val=0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return val;
    }
    void dfs(TreeNode node,int curHeight){
        if (node==null) return;
        if (curHeight>height) {
            height=curHeight;
            val=node.val;
        }
        dfs(node.left,curHeight+1);
        dfs(node.right,curHeight+1);
    }
    //bfs
//    public int findBottomLeftValue(TreeNode root) {
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        TreeNode node =new TreeNode();
//        while (!q.isEmpty()){
//            node=q.poll();
//            if (node.right!=null){
//                q.offer(node.right);
//            }
//            if (node.left!=null){
//                q.offer(node.left);
//            }
//        }
//        return node.val;
//    }

}
