package medium;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class amountOfTime {
    List<List<Integer>> matrix;
    public int amountOfTime(TreeNode root, int start) {
        matrix = new ArrayList<>();
        boolean[] isVisited = new boolean[100001];
        int time = 0;

        for(int i = 0;i<=100001;i++){
            matrix.add(new ArrayList<>());
        }

        dfs(root,-1);
        isVisited[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        while(!q.isEmpty()){
            time++;
            int qSize = q.size();
            for (int i = 0;i<qSize;i++) {
                int cur = q.poll();
                // System.out.println(cur);
                List<Integer> list = matrix.get(cur);
                for (Integer integer : list) {
                    if (!isVisited[integer]) {
                        q.offer(integer);
                        isVisited[integer] = true;
                    }
                }
            }
        }
        return time;

    }

    void dfs(TreeNode root,int prev){
        if(root == null){
            return;
        }
        int curVal = root.val;
        if(prev!=-1){
            matrix.get(curVal).add(prev);
            matrix.get(prev).add(curVal);
        }

        dfs(root.left,curVal);
        dfs(root.right,curVal);
    }
}
