/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
          var fast = head?.next
  var slow = head
  while (fast != null) {
    if (fast === slow) return true
    fast = fast.next?.next
    slow = slow?.next
  }
  return false

    }
}
