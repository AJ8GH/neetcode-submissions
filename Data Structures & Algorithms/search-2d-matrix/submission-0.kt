class Solution {
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
  var start = 0
  var end = matrix.lastIndex

  while (start <= end) {
    val pivot = (end - start) / 2 + start
    val row = matrix[pivot]
    when {
      target in row.first()..row.last() -> return searchRow(row, target)
      target < row.first() -> end = pivot - 1
      target > row.last() -> start = pivot + 1
    }
  }
  return false
}

private fun searchRow(row: IntArray, target: Int): Boolean {
  var start = 0
  var end = row.lastIndex

  while (start <= end) {
    val pivot = (end - start) / 2 + start
    when {
      row[pivot] == target -> return true
      row[pivot] < target -> start = pivot + 1
      row[pivot] > target -> end = pivot - 1
    }
  }
  return false
}

}
