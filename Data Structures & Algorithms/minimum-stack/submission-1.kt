

const val INITIAL_CAPACITY = 16
const val LOAD_FACTOR = 0.75f
const val MULTIPLIER = 2

class MinStack {

  private var stack = IntArray(INITIAL_CAPACITY)
  private val mins = ArrayDeque<Int>()
  private var size = 0

  fun push(`val`: Int) {
    if (size >= stack.size * LOAD_FACTOR) {
      stack = stack.copyOf(stack.size * MULTIPLIER)
    }
    stack[size++] = `val`
    mins.add(minOf(`val`, mins.lastOrNull() ?: `val`))
  }

  fun pop() {
    size--
    mins.removeLast()
  }

  fun top(): Int {
    return stack[size - 1]
  }

  fun getMin(): Int {
    return mins.last
  }
}
