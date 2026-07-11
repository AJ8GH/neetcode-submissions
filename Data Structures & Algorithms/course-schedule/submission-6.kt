class Solution {
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
  val counts = IntArray(numCourses)
  for ((course, _) in prerequisites) {
    counts[course]++
  }

  val prereqsByDependent = prerequisites.groupBy { it.last() }
  val queue = ArrayDeque<Int>()
  for ((i, c) in counts.withIndex()) {
    if (c == 0) {
      queue.addLast(i)
    }
  }

  while (queue.isNotEmpty()) {
    val course = queue.removeFirst()
    val dependents = prereqsByDependent[course] ?: emptyList()
    for ((depCourse, _) in dependents) {
      counts[depCourse]--
      if (counts[depCourse] == 0) {
        queue.add(depCourse)
      }
    }
  }
  return counts.all { it <= 0 }
}


}