class Solution {
fun isPalindrome(s: String): Boolean {
  var i = 0
  var j = s.lastIndex
  while (i < j) {
    var a = s[i]
    while (isValidChar(a)) {
      if (i >= j) break
      a = s[++i]
    }
    if (a < 'a') a += 32

    var b = s[j]
    while (isValidChar(b)) {
      if (i >= j) break
      b = s[--j]
    }
    if (b < 'a') b += 32
    if (a != b) return false
    i++
    j--
  }
  return true
}

private fun isValidChar(c: Char) =
  c !in 'A'..'Z'
      && c !in '0'..'9'
      && c !in 'a'..'z'
      && c.code !in 127..160

}
