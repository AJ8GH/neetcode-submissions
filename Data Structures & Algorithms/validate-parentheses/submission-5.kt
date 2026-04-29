class Solution {
fun isValid(s: String): Boolean {
  val opening = setOf('(', '{', '[')
  val stack = ArrayDeque<Char>()
  for (c in s) {
    if (c in opening) stack.addFirst(c)
    else {
      if (stack.isEmpty()) return false
      if (!isMatch(stack.removeFirst(), c)) return false
    }
  }
  return stack.isEmpty()
}

private fun isMatch(opening: Char, closing: Char): Boolean {
  return when (opening) {
    '(' -> closing == ')'
    '{' -> closing == '}'
    '[' -> closing == ']'
    else -> error("invalid opening char: $opening")
  }
}

}
