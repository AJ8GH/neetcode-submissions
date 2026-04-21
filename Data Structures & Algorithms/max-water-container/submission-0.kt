class Solution {
    fun maxArea(heights: IntArray): Int {
  var i = 0
  var j = heights.lastIndex
  var maxArea = 0
  while (i < j) {
    val area = calculateArea(heights, i, j)
    maxArea = max(maxArea, area)
    if (heights[i] < heights[j]) i++
    else j--
  }
  return maxArea
}

private fun calculateArea(heights: IntArray, i: Int, j: Int) =
  min(heights[i], heights[j]) * (j - i)

}
