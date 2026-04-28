import kotlin.Int.Companion.MAX_VALUE

class Solution {
fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {  
  val maxes = IntArray((nums.size - k) + 1)
  val heap = PriorityQueue(reverseOrder<Int>())
  for (i in nums.indices) {
    if (i >= k && nums[i - k] >= (heap.peek() ?: MAX_VALUE)) heap.poll()
    if (nums[i] > (heap.peek() ?: MAX_VALUE)) heap.poll()
    heap.add(nums[i])
    if (i >= k - 1) maxes[(i - k) + 1] = heap.peek()
  }
  return maxes
}

}
