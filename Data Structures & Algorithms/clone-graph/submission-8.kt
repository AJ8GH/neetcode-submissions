/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {
  node ?: return null
  val vertices = mutableMapOf<Int, Node>()
  val visited = mutableSetOf<Int>()
  val nodes = ArrayDeque(listOf(node))
  while (nodes.isNotEmpty()) {
    val node = nodes.removeFirst()
    if (node.`val` in visited) continue
    visited.add(node.`val`)
    val nodeClone = vertices.getOrPut(node.`val`) { Node(node.`val`) }
    for (n in node.neighbors) {
      val nClone = vertices.getOrPut(n!!.`val`) { Node(n.`val`) }
      nodeClone.neighbors.add(nClone)
      if (n.`val` !in visited) nodes.addLast(n)
    }
  }
  return vertices[1]
}

}



