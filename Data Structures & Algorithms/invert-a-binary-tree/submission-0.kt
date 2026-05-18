/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
  val nodes = ArrayDeque(listOfNotNull(root))
  while (nodes.isNotEmpty()) {
    val node = nodes.removeFirst()
    val left = node.left
    node.left = node.right
    node.right = left
    node.right?.let { nodes.addLast(it) }
    node.left?.let { nodes.addLast(it) }
  }
  return root

    }
}
