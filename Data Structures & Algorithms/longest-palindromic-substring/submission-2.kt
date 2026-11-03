class Solution {
fun longestPalindrome(s: String): String {
  if (s.length < 2) return s
  var best = Pair(0, 0)
  for (i in 0 until s.lastIndex) {
    val p = find(s, i, i)
    val pEven = find(s, i, i + 1)
    if (p.second - p.first > best.second - best.first) best = p
    if (pEven.second - pEven.first > best.second - best.first) best = pEven
  }
  return s.substring(best.first, best.second + 1)
}

fun find(s: String, idxI: Int, idxJ: Int): Pair<Int, Int> {
  var i = idxI
  var j = idxJ
  if (s[i] != s[j]) return Pair(0, 0)
  var bestI = i
  var bestJ = j
  while (i >= 0 && j <= s.lastIndex && s[i] == s[j]) {
    bestI = i--
    bestJ = j++
  }
  return Pair(bestI, bestJ)
}


}
