package hard;

import util.Node;
import util.TreeNode;

import java.util.*;

public class verticalTraversal {
    protected class Node{
        int row;
        int col;
        TreeNode node;
        public Node(int row,int col,TreeNode node){
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0 ,0,root));
        List<Node> list = new ArrayList<>();
        list.add(new Node(0,0,root));
        while (!q.isEmpty()){
            Node cur = q.poll();
            if (cur.node.left!=null){
                Node left = new Node(cur.row+1, cur.col-1,cur.node.left);
                list.add(left);
                q.offer(left);
            }
            if (cur.node.right!=null){
                Node right = new Node(cur.row+1, cur.col+1, cur.node.right);
                list.add(right);
                q.offer(right);
            }
        }
        list.sort((o1, o2) -> {
            if (o1.col==o2.col){
                if (o1.row==o2.row) return o1.node.val-o2.node.val;
                return o1.row-o2.row;
            }
            return o1.col-o2.col;
        });
        List<List<Integer>> ansList = new ArrayList<>();
        int pre = list.get(0).col;
        ArrayList<Integer> preSubList = new ArrayList<>();
        for (Node node : list) {
            if (node.col==pre){
               preSubList.add(node.node.val);
            }else {
                ansList.add(preSubList);
                preSubList = new ArrayList<>();
                preSubList.add(node.node.val);
            }
            pre = node.col;
        }
        ansList.add(preSubList);
        return ansList;
    }
}
