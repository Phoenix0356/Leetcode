package medium;

import util.TreeNode;

import java.util.HashMap;

public class buildTree3 {
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int len = preorder.length;
        for(int i = 0;i < len;i++){
            map.put(postorder[i],i);
        }
        return construct(preorder,0,len-1,postorder,0,len-1);
    }

    TreeNode construct(int[] preorder,int preLeft,int preRight,
                       int[] postorder,int postLeft, int postRight){
        if(preLeft>preRight) return null;
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        int subRootVal = preorder[preLeft];
        TreeNode root = new TreeNode(subRootVal);

        int leftSubroot = preorder[preLeft+1];
        int leftRootIndex = map.get(leftSubroot);

        int leftSize = leftRootIndex-postLeft+1;

        root.left = construct(preorder,preLeft+1,preLeft+leftSize,
                postorder,postLeft,leftRootIndex);
        root.right = construct(preorder,preLeft+leftSize+1,preRight,
                postorder,leftRootIndex+1,postRight);

        return root;

    }
}
