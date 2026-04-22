class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
  /*
  a, b, z, x, y, z, c, g
   */

  val found = mutableSetOf<Char>()
  var start = 0
  var longest = 0
  for (i in s.indices) {
    val c = s[i]
    if (!found.add(c)) {
      var startChar = s[start]
      while (startChar != c) {
        found.remove(startChar)
        startChar = s[++start]
      }
      start++
    } else {
      longest = maxOf(longest, (i - start) + 1)
    }
  }

    return longest

    }
}
