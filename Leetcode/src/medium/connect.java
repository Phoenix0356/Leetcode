package medium;


import util.*;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class connect {
    //bfs
//    class Pair{
//        public Node node;
//        public int depth;
//        public Pair(Node node,int depth){
//            this.node = node;
//            this.depth = depth;
//        }
//    }
//    public Node connect(Node root) {
//        Queue<Pair> q = new ArrayDeque<>();
//        q.offer(new Pair(root,0));
//        while (!q.isEmpty()){
//            Pair cur = q.poll();
//            Node curNode = cur.node;
//            int curD = cur.depth;
//            if (curNode.left!=null) q.offer(new Pair(curNode.left,curD+1));
//            if (curNode.right!=null) q.offer(new Pair(curNode.right,curD+1));
//            if (q.peek() == null||q.peek().depth!=curD) curNode.next = null;
//            else curNode.next = q.peek().node;
//        }
//        return root;
//    }
    public Node connect(Node root) {
        if (root == null|| root.left == null || root.right == null) return null;
        dfs(root.left,root.right);
        return root;

    }

    void dfs(Node node1, Node node2){
        if (node1 == null|| node2 == null) return;

        node1.next = node2;

        dfs(node1.left,node1.right);
        dfs(node1.right,node2.left);
        dfs(node2.left,node2.right);

    }
}
