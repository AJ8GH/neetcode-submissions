class Solution {
fun search(nums: IntArray, target: Int): Int {
  var start = 0
  var end = nums.lastIndex

  while (start <= end) {
    val pivot = (end - start) / 2 + start
    when {
      nums[pivot] == target -> return pivot
      nums[pivot] > target -> end = pivot - 1
      nums[pivot] < target -> start = pivot + 1
    }
  }

  return -1
}

}
