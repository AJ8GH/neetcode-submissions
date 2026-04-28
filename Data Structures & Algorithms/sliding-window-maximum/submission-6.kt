import kotlin.Int.Companion.MIN_VALUE

class Solution {
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
      val maxes = IntArray((nums.size - k) + 1)
  val heap = PriorityQueue(reverseOrder<Int>())
  for (i in nums.indices) {
    if (i >= k && heap.isNotEmpty() && nums[i - k] >= heap.peek()) {
      heap.poll()
    }
    if (heap.isNotEmpty() && nums[i] > heap.peek()) {
      heap.poll()
    }
    heap.add(nums[i])
    if (i >= k - 1) {
      maxes[(i - k) + 1] = heap.peek()
    }
  }
  return maxes

}

}
