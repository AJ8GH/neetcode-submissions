import kotlin.Int.Companion.MAX_VALUE
import kotlin.Int.Companion.MIN_VALUE

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
fun isValidBST(root: TreeNode?): Boolean {
  root ?: return true
  return isValidBST(root.left, null, root.`val`)
      && isValidBST(root.right, root.`val`, null)
}

private fun isValidBST(
  root: TreeNode?,
  leftParent: Int?,
  rightParent: Int?,
): Boolean {
  root ?: return true

  if (leftParent != null && leftParent >= root.`val`) return false
  if (rightParent != null && rightParent <= root.`val`) return false

  val rightParentForLeft = rightParent?.let { minOf(root.`val`, it) } ?: root.`val`
  val leftParentForRight = leftParent?.let { maxOf(root.`val`, it) } ?: root.`val`

  return isValidBST(root.left, leftParent, rightParentForLeft)
      && isValidBST(root.right, leftParentForRight, rightParent)
}

}
