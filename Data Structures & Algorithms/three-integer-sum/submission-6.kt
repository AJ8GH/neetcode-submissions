class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
  nums.sort()
  val triples = mutableListOf<List<Int>>()

  for (i in nums.indices) {
    if (i > 0 && nums[i] == nums[i - 1]) continue
    var j = i + 1
    var k = nums.lastIndex

    while (j < k) {
      val iVal = nums[i]
      val jVal = nums[j]

      val kVal = nums[k]
      if (k < nums.lastIndex && kVal == nums[k + 1]) {
        k--
        continue
      }

      val sum = iVal + jVal + kVal
      if (sum > 0) k--
      if (sum < 0) j++
      if (sum == 0) {
        triples.add(listOf(iVal, jVal, kVal))
        j++
        k--
      }
    }
  }

  return triples.toList()
    }
}
