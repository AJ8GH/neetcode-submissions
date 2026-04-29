class Solution {
fun isValid(s: String): Boolean {
  val opening = setOf('(', '{', '[')
  val closing = setOf(')', '}', ']')
  val stack = Stack<Char>()
  for (c in s) {
    if (c in opening) stack.push(c)
    if (c in closing) {
      if (stack.isEmpty()) return false
      if (!isMatch(stack.pop(), c)) return false
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
