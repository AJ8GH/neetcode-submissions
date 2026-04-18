class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val buckets = Array(nums.size + 1) { mutableListOf<Int>() }
    val count = mutableMapOf<Int, Int>()
    val out = IntArray(k)
  
    for (i in nums) count.merge(i, 1, Int::plus)
    for (e in count) buckets[e.value].add(e.key)
  
    var j = 0
    for (i in buckets.indices.reversed()) {
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
