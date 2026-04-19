const val EMPTY = '.'

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
  val sets = mutableMapOf<String, MutableSet<Char>>()
  for (i in board.indices) {
    for (j in board[i].indices) {
      val c = board[i][j]
      if (c == EMPTY) {
        continue
      }

      if (!sets.computeIfAbsent("${j}c") { mutableSetOf() }.add(c)) {
        return false
      }
      if (!sets.computeIfAbsent("${i}r") { mutableSetOf() }.add(c)) {
        return false
      }
      if (!sets.computeIfAbsent("${i / 3}-${j / 3}q") { mutableSetOf() }.add(c)) {
        return false
      }
    }
  }
  return true

    }
}
