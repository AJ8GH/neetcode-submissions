import kotlin.Int.Companion.MIN_VALUE

class Solution {
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
      val maxes = IntArray((nums.size - k) + 1)
  val heap = PriorityQueue(reverseOrder<Int>())
  for (i in nums.indices) {
    if (i >= k) heap.remove(nums[i - k])
    heap.add(nums[i])
    if (i >= k - 1) maxes[(i - k) + 1] = heap.peek()
  }
  return maxes

}

}
