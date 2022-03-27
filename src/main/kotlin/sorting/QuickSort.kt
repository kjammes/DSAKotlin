package sorting

fun main() {
    val nums = ArrayList(mutableListOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0))
    quickSort(nums, 0, nums.size - 1)
    println(nums)
}

fun quickSort(nums: ArrayList<Int>, low: Int, high: Int) {
    if(low < high) {
        var pivot = partition(nums, low, high)
        quickSort(nums, low, pivot - 1)
        quickSort(nums, pivot + 1, high)
    }
}

fun partition(nums: ArrayList<Int>, low: Int, high: Int): Int {
    var pivot = nums[low]
    var i = low
    var j = high

    while (i < j) {
        while (nums[i] <= pivot) i++
        while (nums[j] > pivot) j--

        if(i < j)
            swapNums(i, j, nums)
    }
    swapNums(low, j, nums)

    return j
}

fun swapNums(nOne: Int, nTwo: Int, nums: ArrayList<Int>) {
    var temp = nums[nOne]
    nums[nOne] = nums[nTwo]
    nums[nTwo] = temp
}
