/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
  return maxDepth(root, 0)
}

private fun maxDepth(root: TreeNode?, depth: Int): Int {
  root ?: return depth
  return maxOf(
    maxDepth(root.left, depth + 1),
    maxDepth(root.right, depth + 1)
  )
}

}
