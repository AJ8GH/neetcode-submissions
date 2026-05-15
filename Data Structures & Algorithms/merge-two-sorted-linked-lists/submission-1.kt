/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
  var l1 = list1
  var l2 = list2
  var head: ListNode? = null
  var current: ListNode? = null

  while (l1 != null || l2 != null) {
    var new: ListNode?

    if (l2 == null || (l1 != null && l1.`val` < l2.`val`)) {
      new = l1
      l1 = l1!!.next
    } else {
      new = l2
      l2 = l2.next
    }

    new.next = null

    if (head == null) {
      head = new
      current = head
    } else {
      current?.next = new
      current = current?.next
    }
  }

  return head

    }
}
