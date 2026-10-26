class Solution {
fun rob(nums: IntArray): Int {
      if (nums.size == 1) return nums.first()

  val best = IntArray(nums.size)
  var max = nums.first()
  for (i in nums.indices) {
    if (i < 2) {
      best[i] = nums[i]
    } else {
      best[i] = max + nums[i]
      max = max(max, best[i - 1])
    }
  }
  return max(best.last(), best[best.lastIndex - 1])
}

}
