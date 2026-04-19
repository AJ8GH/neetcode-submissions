const val EMPTY = '.'

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
          val rows = mutableMapOf<Int, MutableSet<Char>>()
  val cols = mutableMapOf<Int, MutableSet<Char>>()
  val squares = mutableMapOf<Int, MutableSet<Char>>()
  for (i in board.indices) {
    for (j in board[i].indices) {
      val c = board[i][j]
      if (c == EMPTY) continue
      if (!rows.computeIfAbsent(i) { mutableSetOf() }.add(c)) return false
      if (!cols.computeIfAbsent(j) { mutableSetOf() }.add(c)) return false
      val key = (i / 3) * 3 + 3 + (j / 3)
      if (!squares.computeIfAbsent(key) { mutableSetOf() }.add(c)) return false
    }
  }
  return true
    }
}
