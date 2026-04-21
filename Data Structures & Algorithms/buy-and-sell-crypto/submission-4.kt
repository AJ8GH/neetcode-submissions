import kotlin.Int.Companion.MAX_VALUE
import kotlin.Int.Companion.MIN_VALUE


class Solution {
    fun maxProfit(prices: IntArray): Int {
  var maxProfit = MIN_VALUE
  var bestBuy = MAX_VALUE
  for (i in 0 until prices.lastIndex) {
    bestBuy = minOf(prices[i], bestBuy)
    val profit = prices[i + 1] - bestBuy
    maxProfit = maxOf(maxProfit, profit)
  }
  return maxOf(maxProfit, 0)
      }
}
