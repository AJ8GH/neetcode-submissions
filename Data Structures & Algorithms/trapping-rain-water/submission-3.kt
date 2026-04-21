class Solution {
    fun trap(height: IntArray): Int {
  var i = 0
  var j = height.lastIndex
  var area = 0
  var leftWall = height.first()
  var rightWall = height.last()
  while (i < j) {
    if (leftWall < rightWall) {
      area += maxOf(leftWall - height[i++], 0)
      leftWall = maxOf(leftWall, height[i])
    } else {
      area += maxOf(rightWall - height[j--], 0)
      rightWall = maxOf(rightWall, height[j])
    }
  }
  return area

    }
}
