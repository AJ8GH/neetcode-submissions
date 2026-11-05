class Solution {
fun countSubstrings(s: String): Int {
  var total = 0
  for (i in 0..s.lastIndex) {
    total += expand(s, i, i)
    total += expand(s, i, i + 1)
  }
  return total
}

private fun expand(s: String, first: Int, last: Int): Int {
  var total = 0
  var i = first
  var j = last
  while (i >= 0 && j <= s.lastIndex && s[i] == s[j]) {
    total++
    i--
    j++
  }
  return total
}

}
