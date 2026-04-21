class Solution {
    fun trap(height: IntArray): Int {
  var i = 0
  var j = height.lastIndex
  val depressions = Array<Int?>(height.size) { null }
  var leftWall = height.first()
  var rightWall = height.last()
  while (i < j) {
    if (height[j] < rightWall) depressions[j] = rightWall - height[j]
    if (height[i] < leftWall) depressions[i] = leftWall - height[i]
    if (height[i] > leftWall) leftWall = height[i]
    if (height[j] > rightWall) rightWall = height[j]
    if (height[i] < height[j]) i++
    else j--
  }

  return depressions.sumOf { it ?: 0 }

    }
}
