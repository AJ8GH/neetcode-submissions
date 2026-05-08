class Solution {
  fun search(nums: IntArray, target: Int): Int {
    val rotation = findRotation(nums)
    var lowerBound = 0
    var upperBound = nums.lastIndex
    while (lowerBound <= upperBound) {
      val pivot = (upperBound - lowerBound) / 2 + lowerBound
      val rotatedPivot = (pivot + rotation) % nums.size
      if (nums[rotatedPivot] == target) return rotatedPivot
      if (nums[rotatedPivot] < target) lowerBound = pivot + 1
      if (nums[rotatedPivot] > target) upperBound = pivot - 1
    }
    return -1
  }

  @Suppress("DuplicatedCode")
  private fun findRotation(nums: IntArray): Int {
    var lowerBound = 0
    var upperBound = nums.lastIndex
    while (lowerBound < upperBound) {
      val pivot = (upperBound - lowerBound) / 2 + lowerBound
      if (nums[pivot] > nums[upperBound]) lowerBound = pivot + 1
      else upperBound = pivot
    }
    return lowerBound
  }

}
