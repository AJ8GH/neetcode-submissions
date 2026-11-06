class Solution {
fun coinChange(coins: IntArray, amount: Int): Int {
  val sorted = coins.sortedArrayDescending()
  val best = IntArray(amount + 1)
  outer@ for (i in 1..amount) {
    var minimumCoins = Int.MAX_VALUE
    for (c in sorted) {
      if (c > i) continue
      if (c == i) {
        best[i] = 1
        continue@outer
      }
      val amountMinusCoin = i - c
      val coinsRequired = best[amountMinusCoin]
      if (coinsRequired > 0) {
        minimumCoins = minOf(minimumCoins, coinsRequired + 1)
      }
    }
    if (minimumCoins != Int.MAX_VALUE) {
      best[i] = minimumCoins
    } else {
      best[i] = findBest(sorted, i)
    }
  }
  return best.last()
}

private fun findBest(coins: IntArray, amount: Int): Int {
  var count = 0
  var remaining = amount
  var previousRemaining = remaining
  while (remaining > 0) {
    for (c in coins.sortedArrayDescending()) {
      while (c <= remaining) {
        remaining -= c
        count++
      }
    }
    if (previousRemaining == remaining) return -1
    previousRemaining = remaining
  }
  return count
}

}
