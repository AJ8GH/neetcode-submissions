/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
          head?.next ?: return null
  var nPlusOneFromEnd = head
  var end = head
  repeat(n) { end = end?.next }
  end ?: return head.next
  while (end?.next != null) {
    end = end.next
    nPlusOneFromEnd = nPlusOneFromEnd?.next
  }
  nPlusOneFromEnd?.next = nPlusOneFromEnd.next?.next
  return head
    }
}
