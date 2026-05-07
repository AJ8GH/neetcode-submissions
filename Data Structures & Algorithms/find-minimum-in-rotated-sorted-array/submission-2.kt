class Solution {
fun findMin(nums: IntArray): Int {
  var lowerBound = 0
  var upperBound = nums.lastIndex
  var min = nums.first()
  while (lowerBound <= upperBound) {
    val pivot = (upperBound - lowerBound) / 2 + lowerBound
    when {
      nums[pivot] >= min -> lowerBound = pivot + 1
      nums[pivot] < min -> {
        min = nums[pivot]
        upperBound = pivot - 1
      }
    }
  }
  return min
}


}
