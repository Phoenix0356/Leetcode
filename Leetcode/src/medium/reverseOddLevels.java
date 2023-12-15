package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class reverseOddLevels {
    public TreeNode reverseOddLevels(TreeNode root) {
        ArrayList<TreeNode> pre=new ArrayList<>();
        ArrayList<TreeNode> cur=new ArrayList<>();
        pre.add(root);
        int pow=0;
        outer:while (true){
            int limit=1<<pow++;
            System.out.println(pow);
            for (int i=0;i<limit;i++){
                if (pre.get(i).left==null) break outer;
                cur.add(pre.get(i).left);
                cur.add(pre.get(i).right);
            }
            if (pow%2==1){
                int size= cur.size();
                for (int i=0;i<size/2;i++){
                    int temp=cur.get(i).val;
                    cur.get(i).val=cur.get(size-1-i).val;
                    cur.get(size-1-i).val=temp;
                }
            }
            pre.clear();
            pre.addAll(cur);
            cur.clear();

        }
        return root;
    }
}
