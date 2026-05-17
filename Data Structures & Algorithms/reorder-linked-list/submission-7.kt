/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
fun reorderList(head: ListNode?) {
  head ?: return
  var first = head
  var second = split(head)
  second = reverse(second)
  while (first != null) {
    val tmp = first.next
    first.next = second
    first = second
    second = tmp
  }
}

private fun split(head: ListNode): ListNode? {
  var slow: ListNode? = head
  var fast: ListNode? = head.next
  while (fast?.next != null) {
    fast = fast.next?.next
    slow = slow?.next
  }
  val ret = slow?.next
  slow?.next = null
  return ret
}

private fun reverse(second: ListNode?): ListNode? {
  var current: ListNode?
  current = second
  var next = current?.next
  current?.next = null
  while (next != null) {
    val tmp = next.next
    next.next = current
    current = next
    next = tmp
  }
  return current
}

}
