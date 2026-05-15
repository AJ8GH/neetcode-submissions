/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
fun reverseList(head: ListNode?): ListNode? {
  var a = head
  var b = head?.next
  a?.next = null
  while (a != null && b != null) {
    val tmp = b.next
    b.next = a
    a = b
    b = tmp
  }

  return a
}

}
