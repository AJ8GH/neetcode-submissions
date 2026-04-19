class Solution {
    fun longestConsecutive(nums: IntArray): Int {
          val found = nums.toSet()
  var max = 0
  for (n in found) {
    if (!found.contains(n - 1)) {
      var next = n + 1
      while (found.contains(next)) next++
      max = max(max, next - n)
    }
  }
  return max

    }
}
