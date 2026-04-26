import kotlin.Int.Companion.MAX_VALUE

class Solution {
    fun minWindow(s: String, t: String): String {
          val actualCount = mutableMapOf<Char, Int>()
  var expectedCount = t.groupingBy { it }.eachCount()
  var start = 0
  var end = s.lastIndex
  var minWindowFound = false
  var actualMatches = 0
  var minWindow = MAX_VALUE
  var finalStart = 0
  var finalEnd = 0

  for ((i, c) in s.withIndex()) {
    actualCount[c] = (actualCount[c] ?: 0) + 1
    if (actualCount[c] == expectedCount[c]) actualMatches++
    while (actualMatches == expectedCount.keys.size) {
      minWindowFound = true
      end = i
      if (end - start < minWindow) {
        minWindow = end - start
        finalStart = start
        finalEnd = end
      }
      val startChar = s[start]
      actualCount[startChar] = actualCount[startChar]!! - 1
      start++
      if (
        expectedCount.containsKey(startChar)
        && actualCount[startChar]!! < expectedCount[startChar]!!
      ) actualMatches--
    }
  }
  return if (minWindowFound) s.substring(finalStart, finalEnd + 1) else ""

    }
}
