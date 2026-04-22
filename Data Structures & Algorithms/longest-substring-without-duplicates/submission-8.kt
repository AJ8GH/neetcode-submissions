class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val found = mutableSetOf<Char>()
  var start = 0
  var longest = 0
  for ((i, c) in s.withIndex()) {
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
