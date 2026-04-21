class Solution {
    fun maxArea(heights: IntArray): Int {
  var i = 0
  var j = heights.lastIndex
  var maxArea = 0
  while (i < j) {
    val area = min(heights[i], heights[j]) * (j - i)
    maxArea = max(maxArea, area)
    if (heights[i] < heights[j]) i++
    else j--
  }
  return maxArea
    }
}
