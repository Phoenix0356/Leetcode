package medium;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class replaceValueInTree {
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        root.val = 0;
        int pre_current = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            int current = 0;
            while (size > 0){
                TreeNode poll = queue.poll();
                poll.val+=pre_current;
                int total = (poll.left!=null?poll.left.val:0)+(poll.right!=null?poll.right.val:0);
                current+=total;
                if(poll.left!=null){
                    poll.left.val = -total;
                    queue.add(poll.left);
                }
                if(poll.right!=null){
                    poll.right.val = -total;
                    queue.add(poll.right);
                }
                size--;
            }
            pre_current =  current;
        }
        return root;
    }

}
