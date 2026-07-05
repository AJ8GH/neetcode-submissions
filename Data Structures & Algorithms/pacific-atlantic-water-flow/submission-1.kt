class Solution {
fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
  val results = mutableListOf<List<Int>>()
  val found = mutableSetOf<Pair<Int, Int>>()

  for ((i, row) in heights.withIndex()) {
    for (j in row.indices) {
      val point = Pair(i, j)
      if (canFlow(point, heights, found, 'P') && canFlow(point, heights, found, 'A')) {
        found.add(point)
        results.add(listOf(point.first, point.second))
      }
    }
  }
  return results
}

private fun canFlow(
  point: Pair<Int, Int>,
  heights: Array<IntArray>,
  found: Set<Pair<Int, Int>>,
  ocean: Char,
): Boolean {
  if (canFlow(point, ocean, heights)) return true
  val paths = ArrayDeque<Pair<Int, Int>>()
  val visited = mutableSetOf<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
  queuePaths(point, paths, visited, heights)
  while (paths.isNotEmpty()) {
    val p = paths.removeFirst()
    if (p in found) return true

    if (canFlow(p, ocean, heights)) return true
    queuePaths(p, paths, visited, heights)
  }
  return false
}

private fun queuePaths(
  point: Pair<Int, Int>,
  paths: ArrayDeque<Pair<Int, Int>>,
  visited: MutableSet<Pair<Pair<Int, Int>, Pair<Int, Int>>>,
  heights: Array<IntArray>,
) {

  queue(point, Pair(point.first - 1, point.second), heights, visited, paths)
  queue(point, Pair(point.first + 1, point.second), heights, visited, paths)
  queue(point, Pair(point.first, point.second - 1), heights, visited, paths)
  queue(point, Pair(point.first, point.second + 1), heights, visited, paths)
}

private fun queue(
  point: Pair<Int, Int>,
  newPoint: Pair<Int, Int>,
  heights: Array<IntArray>,
  visited: MutableSet<Pair<Pair<Int, Int>, Pair<Int, Int>>>,
  paths: ArrayDeque<Pair<Int, Int>>,
) {
  val (i, j) = point
  val (i2, j2) = newPoint
  if (i2 < 0 || j2 < 0 || i2 > heights.lastIndex || j2 > heights[i2].lastIndex) {
    return
  }

  if (heights[i2][j2] <= heights[i][j]) {
    val pair = Pair(point, newPoint)
    if (pair !in visited) {
      visited.add(pair)
      paths.add(newPoint)
    }
  }
}

fun canFlow(p: Pair<Int, Int>, ocean: Char, heights: Array<IntArray>): Boolean {
  val (i, j) = p
  return (ocean == 'P' && (i == 0 || j == 0)) ||
      (ocean == 'A' && (i == heights.lastIndex || j == heights[i].lastIndex))
}
}
