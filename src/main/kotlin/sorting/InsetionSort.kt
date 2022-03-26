package sorting

fun main() {
    val nums = intArrayOf(6, 5, 3, 1, 8, 7, 2, 4)
    insertionSort(nums)
}

fun insertionSort(nums: IntArray) {
    for (i in 0 until nums.size - 1) {
        var ind = i
        while(nums[ind+1] < nums[ind] ) {
            swapNums(ind + 1, ind, nums)
            if(ind <= 0) {
                break
            }
            ind--
        }
        println(nums.contentToString())
    }
}

fun swapNums(nOne: Int, nTwo: Int, nums: IntArray) {
    var temp = nums[nOne]
    nums[nOne] = nums[nTwo]
    nums[nTwo] = temp
}
