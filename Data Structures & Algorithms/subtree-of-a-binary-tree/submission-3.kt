/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
  val candidates = ArrayDeque(listOfNotNull(root))
  val nodes = ArrayDeque(candidates)
  while (nodes.isNotEmpty()) {
    val node = nodes.removeFirst()
    if (node.`val` == subRoot?.`val`) {
      candidates.addLast(node)
    }
    node.left?.let { nodes.addLast(it) }
    node.right?.let { nodes.addLast(it) }
  }

  while (candidates.isNotEmpty()) {
    val node = candidates.removeLast()
    if (isEqual(node, subRoot)) return true
  }
  return false
}

private fun isEqual(node: TreeNode?, subRoot: TreeNode?): Boolean =
  when {
    node == null -> subRoot == null
    node.`val` != subRoot?.`val` -> false
    else -> isEqual(node.left, subRoot.left)
        && isEqual(node.right, subRoot.right)
  }

}