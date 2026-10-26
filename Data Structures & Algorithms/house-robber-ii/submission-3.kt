class Solution {
    fun rob(nums: IntArray): Int {
  if (nums.size <= 2) return nums.max()
  return maxOf(
    findBest(0, nums.lastIndex - 1, nums),
    findBest(1, nums.lastIndex, nums),
  )
}

private fun findBest(firstIndex: Int, lastIndex: Int, nums: IntArray): Int {
  var twoBack = nums[firstIndex]
  var oneBack = maxOf(twoBack, nums[firstIndex + 1]);

  for (i in (firstIndex + 2)..lastIndex) {
    twoBack += nums[i]
    val tmp = twoBack
    twoBack = oneBack
    oneBack = maxOf(oneBack, tmp)
  }

  return oneBack
}
}