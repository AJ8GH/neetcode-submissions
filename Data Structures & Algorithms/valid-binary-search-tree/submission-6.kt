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
  return isValidBST(root.left, MIN_VALUE, root.`val`)
      && isValidBST(root.right, root.`val`, MAX_VALUE)
}

private fun isValidBST(
  root: TreeNode?,
  minBound: Int,
  maxBound: Int,
): Boolean = when {
  root == null -> true
  minBound >= root.`val` -> false
  maxBound <= root.`val` -> false
  else -> isValidBST(root.left, minBound, maxOf(root.`val`, minBound))
      && isValidBST(root.right, minOf(root.`val`, maxBound), maxBound)
}


}
