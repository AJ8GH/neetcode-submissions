class Solution {
fun rob(nums: IntArray): Int {
  var max = nums.first()
  (2..nums.lastIndex).forEach { i ->
    nums[i] = max + nums[i]
    max = max(max, nums[i - 1])
  }
  return max(max, nums.last())
}

}