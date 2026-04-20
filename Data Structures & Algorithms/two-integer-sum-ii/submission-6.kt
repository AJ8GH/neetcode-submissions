class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
  var i = 0
  var j = numbers.lastIndex
  while (i < j) {
    when {
      numbers[i] + numbers[j] < target -> i++
      numbers[i] + numbers[j] > target -> j--
      numbers[i] + numbers[j] == target -> return intArrayOf(i + 1, j + 1)
    }
  }
  error("No solution")

    }
}
