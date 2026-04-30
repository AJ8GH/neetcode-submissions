class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
  val output = IntArray(temperatures.size)
  val stack = ArrayDeque<Pair<Int, Int>>()
  for ((i, temp) in temperatures.withIndex()) {
    while (stack.isNotEmpty() && stack.last().second < temp) {
      val last = stack.removeLast()
      output[last.first] = i - last.first
    }
    stack.add(Pair(i, temp))
  }
  for (p in stack) {
    output[p.first] = 0
  }
  return output
}

}
