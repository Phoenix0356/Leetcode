package medium;

import util.TreeNode;

class TreeNodes {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNodes() {}
      TreeNodes(int val) { this.val = val; }
      TreeNodes(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class constructMaximumBinaryTree {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return construct(nums, 0, nums.length - 1);
        }
    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int best = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > nums[best]) {
                best = i;
            }
        }
        TreeNode node = new TreeNode(nums[best]);
        node.left = construct(nums, left, best - 1);
        node.right = construct(nums, best + 1, right);
        return node;
    }
}

