package recursion

fun main() {
    println("Factorial of 5 = ${factorial(5)}")
    println("Factorial of 10 = ${factorial(10)}")
}

fun factorial(num: Int): Int {
    return if(num == 0 || num == 1)
        1
    else
        num * factorial(num-1)
}