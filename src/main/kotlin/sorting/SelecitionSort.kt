package sorting

fun main() {
    val nums = intArrayOf(3,4,1,7,9,1,33,4,1,575)
    selectionSort(nums)
    println(nums.contentToString())
}

fun selectionSort(nums: IntArray) {
    for (i in nums.indices) {
        for (j in i+1 until nums.size-1) {
            if(nums[j] < nums[i]) {
                val temp = nums[j]
                nums[j] = nums[i]
                nums[i] = temp
            }
        }
        println(nums.contentToString())
    }
}