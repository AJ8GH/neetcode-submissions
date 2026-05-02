class Solution {
fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
  val sorted = position.withIndex()
    .map { (i, p) -> Pair(p, speed[i]) }
    .sortedByDescending { it.first }

  var fleets = 0
  var max = 0.0

  for (p in sorted) {
    val time = (target - p.first).toDouble() / p.second
    if (time > max) {
      fleets++
      max = time
    }
  }

  return fleets
}

}
