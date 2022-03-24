package sorting

import java.util.*

fun main() {
    val nums = intArrayOf(3,4,1,7,9,1,33,4,1,575)
    bubbleSort(nums)
    println(nums.contentToString())
}

fun bubbleSort(nums: IntArray) {
    for (i in nums.indices) {
        for (j in 0 until nums.size-1) {
            if(nums[j] > nums[j+1]) {
                val temp = nums[j]
                nums[j] = nums[j+1]
                nums[j+1] = temp
            }
        }
    }
}