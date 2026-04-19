class Solution {
fun isPalindrome(s: String): Boolean {
  var i = 0
  var j = s.lastIndex
  while (i < j) {
    while (i < j && !s[i].isLetterOrDigit()) i++
    val a = s[i].lowercaseChar()
    while (i < j && !s[j].isLetterOrDigit()) j--
    val b = s[j].lowercaseChar()
    if (a != b) return false
    i++
    j--
  }
  return true

}
}