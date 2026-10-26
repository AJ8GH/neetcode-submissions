class Solution {

fun climbStairs(n: Int): Int {
  val cache = IntArray(n) { -1 }
  cache[0] = 1
  if (n > 1) cache[1] = 2
  return climbStairs(n - 1, cache)
}

private fun climbStairs(n: Int, cache: IntArray): Int {
  if (cache[n] < 0) {
    cache[n] = climbStairs(n - 1, cache) + climbStairs(n - 2, cache)
  }
  return cache[n]
}

}
