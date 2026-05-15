/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
fun reverseList(head: ListNode?): ListNode? {
  var current = head
  var next = head?.next
  current?.next = null
  while (next != null) {
    val tmp = next.next
    next.next = current
    current = next
    next = tmp
  }

  return current}



}
