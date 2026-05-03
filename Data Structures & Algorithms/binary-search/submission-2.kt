class Solution {
    fun search(nums: IntArray, target: Int): Int {
  if (nums.size == 1) {
    return if (nums.first() == target) 0 else -1
  }

  var start = 0
  var end = nums.lastIndex
  while (start < end) {
    if (nums[start] == target) return start
    if (nums[end] == target) return end
    val pivot = (end - start) / 2 + start
    if (nums[pivot] == target) return pivot
    if (nums[pivot] > target) end = pivot - 1
    if (nums[pivot] < target) start = pivot + 1
  }

  return -1

    }
}
