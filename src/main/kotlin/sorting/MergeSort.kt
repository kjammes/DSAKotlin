package sorting

fun main() {
    val nums = ArrayList(listOf(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0))
    println(mergeSort(nums))
}

fun mergeSort(nums: List<Int>): List<Int> {
    if(nums.size == 1)
        return nums

    val left = nums.subList(0, nums.size / 2)
    val right = nums.subList(nums.size/2, nums.size)

    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var leftPointer = 0
    var rightPointer = 0

    val result = ArrayList<Int>()

    while (leftPointer < left.size && rightPointer < right.size) {
        if(left[leftPointer] < right[rightPointer]) {
            result.add(left[leftPointer++])
        } else {
            result.add(right[rightPointer++])
        }
    }

    while (leftPointer < left.size) {
        result.add(left[leftPointer++])
    }

    while (rightPointer < right.size) {
        result.add(right[rightPointer++])
    }

    return result

}
