class Solution {
  fun search(nums: IntArray, target: Int): Int {
    var lowerBound = 0
    var upperBound = nums.lastIndex
    while (lowerBound <= upperBound) {
      val pivotIndex = (upperBound - lowerBound) / 2 + lowerBound
      val pivot = nums[pivotIndex]
      if (pivot == target) return pivotIndex
      val lower = nums[lowerBound]
      val upper = nums[upperBound]
      when {
        lower <= pivot && target in lower..pivot -> upperBound = pivotIndex - 1
        lower <= pivot -> lowerBound = pivotIndex + 1
        upper > pivot && target in pivot..upper -> lowerBound = pivotIndex + 1
        upper > pivot -> upperBound = pivotIndex - 1
      }
    }
    return -1
  }



}
