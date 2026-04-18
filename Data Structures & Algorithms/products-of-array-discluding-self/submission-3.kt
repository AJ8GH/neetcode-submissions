class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
  val products = IntArray(nums.size) { 1 }
  for (i in 1..nums.lastIndex) products[i] = products[i - 1] * nums[i - 1]
  var product = 1
  for (i in (nums.lastIndex - 1) downTo 0) {
    product *= nums[i + 1]
    products[i] *= product
  }

  return products
    }
}
