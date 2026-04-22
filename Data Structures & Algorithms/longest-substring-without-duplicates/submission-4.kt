class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
  val found = mutableMapOf<Char, Int>()
  var start = 0
  var longest = 0
  for (i in s.indices) {
    val c = s[i]
    if (found.getOrDefault(c, 0) > 0) {
      var startChar = s[start]
      while (startChar != c) {
        found[startChar] = found[startChar]!! - 1
        startChar = s[++start]
      }
      start++
    } else {
      longest = maxOf(longest, (i - start) + 1)
      found[c] = (found[c] ?: 0) + 1
    }
  }

  return longest

    }
}
