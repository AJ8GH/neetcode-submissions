/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
  var first = head?.next
  var prev = head
  while (first != null) {
    if (first == prev) return true
    first = first.next?.next
    prev = prev?.next
  }
  return false
    }
}
