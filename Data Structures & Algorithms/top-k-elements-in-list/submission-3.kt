class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
  val buckets = Array(nums.size) { mutableListOf<Int>() }
  val count = mutableMapOf<Int, Int>()
  for (i in nums) {
    count[i] = (count[i] ?: 0) + 1
  }
  for (e in count) {
    buckets[e.value - 1].add(e.key)
  }

  val out = IntArray(k)
  var j = 0;
  for (i in buckets.lastIndex downTo 0) {
    for (v in buckets[i]) {
      out[j++] = v
      if (j == k) {
        return out
      }
    }
  }
  return out

    }
}
