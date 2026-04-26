class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
          val s1Count = IntArray(26)
  val s2Count = IntArray(26)
  var expectedMatches = 0
  var actualMatches = 0

  for (c in s1) {
    if (s1Count[c - 'a']++ == 0) expectedMatches++
  }
  for ((i, c) in s2.withIndex()) {
    s2Count[c - 'a']++
    if (i > s1.lastIndex) {
      val j = s2[i - s1.length] - 'a'
      s2Count[j]--
      if (s2Count[j] == s1Count[j] - 1) actualMatches--
    }
    if (s1Count[c - 'a'] == s2Count[c - 'a']) actualMatches++
    if (actualMatches == expectedMatches) return true
  }
  return false
    }
}
