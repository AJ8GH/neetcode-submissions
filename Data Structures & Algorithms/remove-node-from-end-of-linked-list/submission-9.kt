/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
          head ?: return null
  var prev = head
  var end = head
  repeat(n) { end = end?.next }
  end ?: return head.next
  while (end?.next != null) {
    end = end.next
    prev = prev!!.next
  }
  prev?.next = prev.next!!.next
  return head

    }
}
