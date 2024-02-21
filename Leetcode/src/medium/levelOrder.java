package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class levelOrder {
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null || root.children.isEmpty()) return new ArrayList<List<Integer>>();
        Queue<List<Node>> q = new ArrayDeque<>();
        List<List<Integer>> l = new ArrayList<>();
        List<Node> subList = new ArrayList<>();
        subList.add(root);
        q.offer(subList);
        while (!q.isEmpty()){
            List<Node> curList = q.poll();
            l.add(getValList(curList));
            subList = setNodeList(curList);
            if (!subList.isEmpty()) q.offer(subList);
        }
        return l;
    }

    protected List<Node> setNodeList(List<Node> nodeList){
        List<Node> nextList = new ArrayList<>();
        for (Node cur : nodeList) {
            if (cur == null || cur.children.isEmpty()) continue;
            nextList.addAll(cur.children);
        }
        return nextList;
    }
    protected ArrayList<Integer> getValList(List<Node> nodeList){
        ArrayList<Integer> list = new ArrayList<>();
        for (Node n:nodeList){
            list.add(n.val);
        }
        return list;
    }
}
