class Solution {
  fun search(nums: IntArray, target: Int): Int {
    var lowerBound = 0
    var upperBound = nums.lastIndex
    while (lowerBound <= upperBound) {
      val pivot = (upperBound - lowerBound) / 2 + lowerBound
      when {
        nums[pivot] == target -> return pivot
        nums[lowerBound] <= nums[pivot] -> {
          if (target in nums[lowerBound]..nums[pivot]) upperBound = pivot - 1
          else lowerBound = pivot + 1
        }

        nums[pivot] < nums[upperBound] -> {
          if (target in nums[pivot]..nums[upperBound]) lowerBound = pivot + 1
          else upperBound = pivot - 1
        }
      }
    }
    return -1
  }


}
