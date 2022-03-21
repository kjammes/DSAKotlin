package stackQueue

class Stack<T> {
    data class Node<T> (var value: T, var next: Node<T>? = null)
    private var top: Node<T>? = null
    private var bottom: Node<T>? = null
    private var length = 0

    fun peek(): Node<T>? {
        if(length == 0)
            println("Stack has no elements")
        return top
    }

    fun push(value: T) {
        val node = Node<T>(value)
        if(length == 0) {
            top = node
            bottom = node
        } else {
            val tempPointer = top
            top = node
            top?.next = tempPointer
        }
        length++
    }

    fun pop(): Node<T>? {
        if (length < 1) {
            println("Stack is empty!!!")
            return null
        }
        if(top == bottom) {
            bottom = null
        }
        val result = top
        top = top?.next
        length--
        return result
    }

    fun printStack() {
        if(length < 1) {
            println("No elements to print :/")
            return
        }

        var node = top
        var result = mutableListOf<T>()
        var index = 0
        while (node?.next != null) {
            result.add(index++, node.value)
            node = node.next
        }
        node?.value?.let { result.add(it) }
        result.forEach(::println)
    }

    fun isEmpty(): Boolean {
        if(top == null && bottom == null)
            return true
        return false
    }
}