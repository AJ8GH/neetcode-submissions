/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean =  when {
    p == null && q == null -> true
    p?.`val` != q?.`val` -> false
    else -> isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
  }

}
