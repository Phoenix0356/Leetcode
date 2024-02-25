package medium;

import util.TreeNode;

import java.util.*;

public class kthLargestLevelSum {
    long[] save = new long[100000];
    public class NodeWithLevel{
        TreeNode node;
        int level;
        public NodeWithLevel(TreeNode node,int level){
            this.node = node;
            this.level = level;
        }
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        bfs(root);
        Arrays.sort(save);
        return save[9999-k]==0?-1:save[9999-k];
    }

    private void bfs(TreeNode root){
        Queue<NodeWithLevel> q = new ArrayDeque<>();
        q.offer(new NodeWithLevel(root,0));
        while (!q.isEmpty()){
            NodeWithLevel cur = q.poll();
            save[cur.level]+=cur.node.val;
            if (cur.node.left!=null) q.offer(new NodeWithLevel(cur.node.left,cur.level+1));
            if (cur.node.right!=null) q.offer(new NodeWithLevel(cur.node.right,cur.level+1));
        }
    }

    private void dfs(TreeNode node,int level){
        if (node==null) return;
        save[level]+=node.val;
        dfs(node.left,level+1);
        dfs(node.right,level+1);
    }
}
