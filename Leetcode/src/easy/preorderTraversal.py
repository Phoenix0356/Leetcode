from util import TreeNode
class Solution:
    def __init__(self):
        self.solution = []
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        self.dfs(root)
        return self.solution
    def dfs(self,node: TreeNode) -> None:
        if node is None:
            return
        self.solution.append(node.val)
        dfs(node.left)
        dfs(node.right)

