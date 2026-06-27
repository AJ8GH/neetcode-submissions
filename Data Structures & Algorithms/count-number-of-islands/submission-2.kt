class Solution {
fun numIslands(grid: Array<CharArray>): Int {
  var islands = 0
  for (i in grid.indices) {
    for (j in grid[0].indices) {
      if (grid[i][j] == '1') {
        islands++
        explore(grid, i, j)
      }
    }
  }
  return islands
}

private fun explore(grid: Array<CharArray>, i: Int, j: Int) {
  if (grid[i][j] == '0') return
  grid[i][j] = '0'
  if (i < grid.size - 1) explore(grid, i + 1, j)
  if (i > 0) explore(grid, i - 1, j)
  if (j < grid[i].size - 1) explore(grid, i, j + 1)
  if (j > 0) explore(grid, i, j - 1)
}

}
