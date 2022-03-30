package dynamic_programming

fun main() {
    println(fibonacciMem(5, HashMap<Int, Int>()))
}

fun fibonacciMem(n: Int, memory: HashMap<Int, Int>): Int {
    return if(memory.containsKey(n))
        memory[n]!!
    else {
        if(n <2) {
            memory[n] = n
            n
        } else {
            println("Long time n = $n")
            memory[n] = fibonacciMem(n - 2, memory) + fibonacciMem(n-1, memory)
            memory[n]!!
        }
    }
}
