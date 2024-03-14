package medium;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree2 {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return construct(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    TreeNode construct(int[] inorder,int inLeft,int inRight,
                       int[] postorder, int postLeft,int postRight){

        if(inLeft>inRight) return null;
        int rootVal = postorder[postRight];
        int inRootIndex = map.get(rootVal);

        TreeNode subRoot = new TreeNode(rootVal);

        int rightSize = inRight - inRootIndex;

        subRoot.left = construct(inorder,inLeft,inRootIndex-1,
                postorder,postLeft,postRight-rightSize-1);
        subRoot.right = construct(inorder,inRootIndex+1,inRight,
                postorder,postRight-rightSize,postRight-1);
        return subRoot;

    }
}
