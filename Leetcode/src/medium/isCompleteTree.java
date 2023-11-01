package medium;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        boolean isNull=false;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur=q.poll();
            if (cur==null){
                if (!isNull) isNull=true;
                continue;
            }
            else {
                if (isNull) return false;
            }
            q.offer(cur.left);
            q.offer(cur.right);

        }
        return true;
    }

}
