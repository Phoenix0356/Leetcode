from util import TreeNode
class Solution:
    def __init__(self):
        self.in_order = []
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root)
        return self.in_order
    def dfs(self,root: TreeNode) -> None:
        if root is None:
            return
        self.dfs(root.left)
        self.in_order.append(root.val)
        self.dfs(root.right)