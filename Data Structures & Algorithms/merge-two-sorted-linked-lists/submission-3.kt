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
  val dummy = ListNode(0)
  var current = dummy

  while (l1 != null || l2 != null) {
    if (l2 == null || (l1 != null && l1.`val` < l2.`val`)) {
      current.next = l1
      l1 = l1!!.next
    } else {
      current.next = l2
      l2 = l2.next
    }
    current = current.next!!
    current.next = null
  }

  return dummy.next

    }
}
