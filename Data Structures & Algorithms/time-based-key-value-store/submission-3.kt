class TimeMap() {

  private val map = mutableMapOf<String, MutableList<Pair<Int, String>>>()

  fun set(key: String, value: String, timestamp: Int) {
    val l = map.getOrPut(key) { mutableListOf() }
    l.add(Pair(timestamp, value))
  }

  fun get(key: String, timestamp: Int): String {
    val l = map[key] ?: emptyList()
    var lowerBound = 0
    var upperBound = l.lastIndex
    var result = ""

    while (lowerBound <= upperBound) {
      val pivot = (upperBound - lowerBound) / 2 + lowerBound
      when {
        l[pivot].first == timestamp -> return l[pivot].second
        l[pivot].first > timestamp -> upperBound = pivot - 1
        l[pivot].first < timestamp -> {
          result = l[pivot].second
          lowerBound = pivot + 1
        }
      }
    }
    return result
  }
}

