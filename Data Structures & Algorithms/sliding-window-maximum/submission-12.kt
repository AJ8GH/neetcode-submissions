import kotlin.Int.Companion.MAX_VALUE

class Solution {
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {  val maxes = IntArray((nums.size - k) + 1)
  val deque = ArrayDeque<Int>()
  for ((i, n) in nums.withIndex()) {
    while (deque.isNotEmpty() && deque.first < n) {
      deque.removeFirst()
    }
    if (deque.isNotEmpty() && i >= k && nums[i - k] == deque.last) {
      deque.removeLast()
    }
    if (deque.isNotEmpty() && n > deque.last) deque.addLast(n)
    else deque.addFirst(n)
    if (i >= k - 1) {
      maxes[(i - k) + 1] = deque.last
    }
  }
  return maxes
}

}
