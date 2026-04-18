class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
  val product = nums.fold(1) { acc, num -> acc * num }
  val products = IntArray(nums.size)
  for (i in nums.indices) {
    var newProduct = 1
    if (nums[i] == 0) {
      for (j in nums.indices) {
        if (j != i) {
          newProduct *= nums[j]
        }
      }
    } else {
      newProduct = product / nums[i]
    }
    products[i] = newProduct
  }
  return products

    }
}
