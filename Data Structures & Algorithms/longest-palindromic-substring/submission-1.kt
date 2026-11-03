class Solution {
fun longestPalindrome(s: String): String {
  if (s.length < 2) return s
  var minI = 0
  var maxJ = 0
  for (i in 0 until s.lastIndex) {
    val p = find(s, i)
    if (p.second - p.first > maxJ - minI) {
      minI = p.first
      maxJ = p.second
    }
  }

  return s.substring(minI, maxJ + 1)
}

fun find(s: String, idx: Int): Pair<Int, Int> {
  var i = idx
  var j = idx
  var minI = i
  var maxJ = j
  val even = findEven(s, i, i + 1)
  while (i >= 0 && j <= s.lastIndex && s[i] == s[j]) {
    minI = i--
    maxJ = j++
  }
  if (even.second - even.first > maxJ - minI) return even
  return Pair(minI, maxJ)
}

fun findEven(s: String, idx: Int, idx1: Int): Pair<Int, Int> {
  var i = idx
  var j = idx1
  if (s[i] != s[j]) return Pair(0, 0)
  var minI = i
  var maxJ = j
  while (i >= 0 && j <= s.lastIndex && s[i] == s[j]) {
    minI = i--
    maxJ = j++
  }
  return Pair(minI, maxJ)
}

}
