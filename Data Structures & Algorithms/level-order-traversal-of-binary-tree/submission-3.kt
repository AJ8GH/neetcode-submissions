/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
  val levels = mutableListOf<List<Int>>()
  val nodes = ArrayDeque(listOfNotNull(root))
  while (nodes.isNotEmpty()) {
    val level = mutableListOf<Int>()
    repeat(nodes.size) {
      val node = nodes.removeFirst()
      level.add(node.`val`)
      node.left?.let { nodes.add(it) }
      node.right?.let { nodes.add(it) }
    }
    levels.add(level)
  }
  return levels
    }
}
