class Solution {
    fun characterReplacement(s: String, k: Int): Int {
          var longest = 0
  var start = 0
  val charCount = mutableMapOf<Char, Int>()
  var maxFrequency = 0
  for ((i, c) in s.withIndex()) {
    val count = (charCount[c] ?: 0) + 1
    charCount[c] = count
    maxFrequency = maxOf(maxFrequency, count)
    while (i - start - maxFrequency >= k) {
      val startChar = s[start]
      val startCharCount = charCount[startChar]!!
      charCount[startChar] = startCharCount - 1
      start++
    }
    longest = maxOf(longest, (i - start) + 1)
  }
  return longest
    }
}
