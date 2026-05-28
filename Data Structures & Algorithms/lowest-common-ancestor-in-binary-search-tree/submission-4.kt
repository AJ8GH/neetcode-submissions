/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return when {
  root!!.`val` in p!!.`val`..(q!!.`val`) -> root
  root.`val` in q.`val`..(p.`val`) -> root
  p.`val` < root.`val` -> lowestCommonAncestor(root.left!!, p, q)
  else -> lowestCommonAncestor(root.right!!, p, q)
    }
  }
}
