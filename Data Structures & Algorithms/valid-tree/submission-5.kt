import java.util.*

class Solution {
fun validTree(n: Int, edges: Array<IntArray>): Boolean {
  if (edges.size != n - 1) return false
  if (edges.isEmpty()) return true

  val edgeMap = mutableMapOf<Int, MutableSet<Int>>()
  for (e in edges) {
    edgeMap.getOrPut(e.first()) { mutableSetOf() }.add(e.last())
    edgeMap.getOrPut(e.last()) { mutableSetOf() }.add(e.first())
  }

  val toVisit = ArrayDeque<Int>()
  toVisit.add(edges.first().first())
  val visited = mutableSetOf<Int>()
  while (toVisit.isNotEmpty()) {
    val current = toVisit.removeFirst()
    visited.add(current)
    for (e in edgeMap[current] ?: emptySet()) {
      if (!visited.contains(e)) {
        toVisit.addLast(e)
      }
    }
  }

  return visited.size == n

}
}