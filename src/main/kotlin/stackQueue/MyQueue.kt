package stackQueue

class MyQueue<T> {
    data class Node<T> (var value: T, var next: Node<T>? = null)
    private var first: Node<T>? = null
    private var last: Node<T>? = null
    private var length = 0

    fun peek(): Node<T>? {
        if(length == 0)
            println("Queue has no elements")
        return first
    }

    fun enqueue(value: T) {
        val node = Node<T>(value)
        if(length == 0) {
            first = node
            last = node
        } else {
            last?.next = node
            last = last?.next
        }
        length++
    }

    fun dequeue(): Node<T>? {
        if(length == 0) {
            println("Queue is empty!!")
            return null
        }
        if(first == last) {
            last = null
        }
        val resultNode = first
        first = first?.next
        return resultNode
    }

    fun print() {
        val result = mutableListOf<T?>()
        var pointer = first
        while (pointer?.next != null) {
            result.add(pointer.value)
            pointer = pointer.next
        }
        result.add(pointer?.value)
        println()
        for(i in result.size-1 downTo 0) {
            println(result[i])
        }
        println()
    }

}