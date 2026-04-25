class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
          val count = IntArray(26)
  for (c in s1) {
    count[c - 'a']++
  }
  for ((i, c) in s2.withIndex()) {
    count[c - 'a']--
    if (i > s1.lastIndex) {
      val j = s2[i - s1.length] - 'a'
      if (count[j] <= 0) count[j]++
    }
    if (count.all { it <= 0 }) return true
  }
  return false

    }
}
