class Solution {
    fun maxProfit(prices: IntArray): Int {
  var i = 0
  var j = 1
  var maxProfit = Int.MIN_VALUE
  while (j <= prices.lastIndex) {
    val profit = prices[j] - prices[i]
    maxProfit = maxOf(maxProfit, profit)
    if (prices[j] < prices[i]) i++
    else j++
    if (j == i) j++
  }
  return maxOf(maxProfit, 0)
    }
}
