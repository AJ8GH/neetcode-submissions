const val EMPTY = '.'

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
  val rows = Array(board.size) { BooleanArray(board.size) }
  val cols = Array(board.size) { BooleanArray(board.size) }
  val squares = Array(board.size) { BooleanArray(board.size) }
  for (i in board.indices) {
    for (j in board[i].indices) {
      val c = board[i][j]
      if (c == EMPTY) continue

      val idx = c - '1'
      if (rows[i][idx]) return false
      if (cols[j][idx]) return false
      val key = (i / 3) * 3 + (j / 3)
      if (squares[key][idx]) return false

      rows[i][idx] = true
      cols[j][idx] = true
      squares[key][idx] = true
    }
  }
  return true

    }
}
