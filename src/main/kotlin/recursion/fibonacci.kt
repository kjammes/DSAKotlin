package recursion

fun main() {
    println(fibonacciR(6))
    println(fibonacciI(6))
}

fun fibonacciI(num: Int): Int {
    return when (num) {
        0 -> {
            0
        }
        1, 2 -> {
            1
        }
        else -> {
            val arr = intArrayOf(1,1)
            for(i in 3 .. num) {
                val temp = arr[1]
                arr[1] = arr[0] + arr[1]
                arr[0] = temp
            }
            arr[1]
        }
    }

}

fun fibonacciR(num: Int): Int {
    if(num < 2)
        return num
    val one = fibonacciR(num - 1)
    val two = fibonacciR(num - 2)
    return  one + two
}