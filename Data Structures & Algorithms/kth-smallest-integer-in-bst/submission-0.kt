/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
fun kthSmallest(root: TreeNode?, k: Int): Int {
  val nodes = ArrayDeque<TreeNode>()
  queueAllLeft(root, nodes)
  var i = 1
  while (nodes.isNotEmpty()) {
    val n = nodes.removeLast()
    if (i == k) return n.`val`
    queueAllLeft(n.right, nodes)
    i++
  }
  error("Not found")
}

private fun queueAllLeft(n: TreeNode?, q: ArrayDeque<TreeNode>) {
  var current = n
  while (current != null) {
    q.addLast(current)
    current = current.left
  }
}

}
