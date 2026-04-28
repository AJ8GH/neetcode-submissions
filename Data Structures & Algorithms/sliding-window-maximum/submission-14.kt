import kotlin.Int.Companion.MAX_VALUE

class Solution {
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
      val maxes = IntArray((nums.size - k) + 1)
  val deque = ArrayDeque<Int>()
  for ((i, n) in nums.withIndex()) {
    while (deque.isNotEmpty() && deque.first < (i - k) + 1) deque.removeFirst()
    while (deque.isNotEmpty() && nums[deque.last] <= n) deque.removeLast()
    deque.addLast(i)
    if (i >= k - 1) maxes[(i - k) + 1] = nums[deque.first]
  }
  return maxes

}

}
