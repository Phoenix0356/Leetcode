package medium;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class subtreeWithAllDeepest {
    int maxDepth = 0;
    TreeNode res = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        searchDepth(root,0);
        return res;
    }

    public int searchDepth(TreeNode root,int curDepth) {
        if (root == null) return curDepth;
        curDepth++;
        int leftDepth = searchDepth(root.left, curDepth);
        int rightDepth = searchDepth(root.right, curDepth);
        if (leftDepth == rightDepth && leftDepth >= maxDepth) {
            maxDepth = leftDepth;
            res = root;
        }
        return Math.max(rightDepth, leftDepth);
    }
}
