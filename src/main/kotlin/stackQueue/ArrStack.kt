package stackQueue

class ArrStack<T> {
    data class Node<T> (var value: T, var next: Node<T>? = null)
    private var stack = mutableListOf<Node<T>?>()

    fun peek(): Node<T>? {
        if(stack.size == 0)
            println("Stack has no elements")
        return stack[stack.size-1]
    }

    fun push(value: T) {
        val node = Node<T>(value)
        stack.add(node);
    }

    fun pop(): Node<T>? {
        if (stack.size < 1) {
            println("Stack is empty!!!")
            return null
        }
        val result = stack[stack.size-1]
        stack.removeAt(stack.size - 1)
        return result
    }

    fun printStack() {
        if(stack.size < 1) {
            println("No elements to print :/")
            return
        }
        println()
        stack.forEach(::println)
        println()
    }

    fun isEmpty(): Boolean {
        if(stack.size == 0)
            return true
        return false
    }

}