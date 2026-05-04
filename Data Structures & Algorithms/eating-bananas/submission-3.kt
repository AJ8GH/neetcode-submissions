import kotlin.Int.Companion.MAX_VALUE

class Solution {
fun minEatingSpeed(piles: IntArray, h: Int): Int {
  var minK = MAX_VALUE
  var lowerBound = 0
  var upperBound = piles.maxOrNull()!!
  while (lowerBound <= upperBound) {
    val k = (upperBound - lowerBound) / 2 + lowerBound
    if (k >= minK) {
      break
    }
    if (canEatAll(piles, h, k)) {
      minK = k
      upperBound = k - 1
    } else {
      lowerBound = k + 1
    }
  }

  return minK
}

fun canEatAll(piles: IntArray, h: Int, k: Int): Boolean {
  var hours = h
  for (p in piles) {
    val spent = ceil(p.toDouble() / k).toInt()
    hours -= spent
    if (hours < 0) return false
  }
  return true
}


}
