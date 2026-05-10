class TimeMap() {

  private val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

  fun set(key: String, value: String, timestamp: Int) {
    val l = map.getOrPut(key) { mutableListOf() }
    l.add(Pair(timestamp, value))
  }

  fun get(key: String, timestamp: Int): String {
    val l = map[key] ?: return ""
    var lowerBound = 0
    var upperBound = l.lastIndex
    while (lowerBound <= upperBound) {
      val pivot = (upperBound - lowerBound) / 2 + lowerBound
      if (l[pivot].first == timestamp) {
        return l[pivot].second
      }
      if (l[pivot].first > timestamp) {
        upperBound = pivot - 1
      }
      if (l[pivot].first < timestamp) {
        if (pivot == l.lastIndex || l[pivot + 1].first > timestamp) return l[pivot].second
        else lowerBound = pivot + 1
      }
    }
    return ""
  }
}
