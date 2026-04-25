class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
  val count = s1.groupingBy { it }.eachCount().toMutableMap()
  for ((i, c) in s2.withIndex()) {
    count[c]?.let { count[c] = it - 1 }
    if (i > s1.lastIndex) {
      val start = s2[i - s1.length]
      count[start]?.let {
        count[start] = it + 1
      }
    }
    if (count.all { it.value == 0 }) return true
  }
  return false
    }
}
