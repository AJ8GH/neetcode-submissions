/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
          head ?: return
  var last = head
  var n = 0
  while (last!!.next != null) {
    last = last.next
    n++
  }

  var second = head
  for (i in 0..n / 2) {
    val tmp = second!!.next
    if (i == n / 2) {
      second.next = null
    }
    second = tmp
  }

  var current = second
  var next = current?.next
  current?.next = null
  while (next != null) {
    val tmp = next.next
    next.next = current
    current = next
    next = tmp
  }

  var first = head
  second = current
  while (first != null) {
    val tmp = first.next
    first.next = second
    first = first.next
    second = tmp
  }
    }
}
