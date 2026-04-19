const val EMPTY = '.'

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
  val rows = Array<MutableSet<Char>>(board.size) { mutableSetOf() }
  val cols = Array<MutableSet<Char>>(board.size) { mutableSetOf() }
  val squares = Array<MutableSet<Char>>(board.size) { mutableSetOf() }
  for (i in board.indices) {
    for (j in board[i].indices) {
      val c = board[i][j]
      if (c == EMPTY) continue
      if (!rows[i].add(c)) return false
      if (!cols[j].add(c)) return false
      val key = (i / 3) * 3 + (j / 3)
      if (!squares[key].add(c)) return false
    }
  }
  return true

    }
}
