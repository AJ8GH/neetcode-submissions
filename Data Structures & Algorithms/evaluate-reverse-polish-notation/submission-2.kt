class Solution {
val OPERATORS = setOf("/", "*", "+", "-")

fun evalRPN(tokens: Array<String>): Int {
  val stack = ArrayDeque<Int>()
  for (c in tokens) {
    if (c in OPERATORS) {
      val b = stack.removeLast()
      val a = stack.removeLast()
      stack.addLast(apply(a, c, b))
    } else stack.add(c.toInt())
  }
  return stack.last()
}

fun apply(a: Int, op: String, b: Int) = when (op) {
  "/" -> a / b
  "*" -> a * b
  "+" -> a + b
  "-" -> a - b
  else -> error("Invalid operation: '$op'")
}

}
