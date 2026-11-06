import kotlin.Int.Companion.MAX_VALUE
class Solution {


fun coinChange(coins: IntArray, amount: Int): Int {
  val coinsDescending = coins.sortedArrayDescending()
  val minCoinsPerAmount = IntArray(amount + 1)
  for (i in 1..amount) {
    minCoinsPerAmount[i] = findMinCoins(coinsDescending, i, minCoinsPerAmount)
  }
  return minCoinsPerAmount.last()
}

private fun findMinCoins(
  coins: IntArray,
  amount: Int,
  minCoinsPerAmount: IntArray,
): Int {
  var minCoins = MAX_VALUE
  for (coin in coins) {
    if (coin == amount) return 1
    if (coin > amount) continue
    val coinsRequired = minCoinsPerAmount[amount - coin]
    if (coinsRequired > 0) minCoins = minOf(minCoins, coinsRequired + 1)
  }
  return if (minCoins != MAX_VALUE) minCoins else -1
}



}
