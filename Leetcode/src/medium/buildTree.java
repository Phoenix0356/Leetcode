package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTree(map,0, preorder.length-1,preorder);

    }
    public TreeNode buildTree(HashMap<Integer,Integer> map,int left,int right,int[] preorder){
        if (left<=right){
            int rootVal=preorder[idx++];
            TreeNode node=new TreeNode(rootVal);
            node.left=buildTree(map,left,map.get(rootVal)-1,preorder);
            node.right=buildTree(map,map.get(rootVal)+1,right,preorder);
            return node;
        }else return null;
    }


}
