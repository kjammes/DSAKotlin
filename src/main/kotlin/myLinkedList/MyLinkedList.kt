package myLinkedList

class MyLinkedList<T> (private val value: T) {
    data class Node<T> (var value: T, var next: Node<T>? = null)
    private var head: Node<T>? = Node(value)
    private var tail: Node<T> = head!!
    private var length = 1

    /**
     * Takes a valid index as input and returns the Node at that index in LinkedList
     */
    private fun getNodeAt(index: Int): Node<T> {
        var cur = head
        var curInd = 0

        while (curInd++ != index && cur?.next != null) {
            cur = cur.next
        }

        return cur!!
    }

    /**
     * Checks whether a given index is in valid range for operations on LinkedList
     */
    private fun isValidIndex(index: Int): Boolean {
        if (index >= length || index < 0 ) {
            println("Please enter a value between zero and length of linked list($length).\n")
            return false
        }
        return true
    }

    /**
     * Inserts value at the tail of LinkedList
     */
    fun insert(value: T) {
        val node = Node(value)
        tail.next = node
        tail = node
        length++
    }

    /**
     * Inserts value at the head of LinkedList
     */
    fun insertAtHead(value: T) {
        val node = Node(value)
        node.next = head
        head = node
        length++
    }

    /**
     * Inserts a value at a given index in LinkedList(assuming valid index)
     */
    fun insertAt(index: Int, value: T) {
        if ( !isValidIndex(index) ) return

        if(index == 0) {
            insertAtHead(value)
            return
        }

        val cur = getNodeAt(index - 1)

        val node = Node(value)
        node.next = cur.next
        cur.next = node

        length++
    }

    /**
     * Removes an element from the given index(assuming valid index)
     */
    fun remove(index: Int) {
        if ( !isValidIndex(index) ) return
        length--

        if(index == 0) {
            head = head?.next
            return
        }

        val leadNode = getNodeAt(index - 1)
        if(leadNode.next?.next == null) {
            tail = leadNode
            return
        }

        leadNode.next = leadNode.next?.next
    }

    /**
     * Prints all the elements in the LinkedList
     */
    fun printAll() {
        println("Head is ${head?.value}, tail is ${tail?.value} & length of linked list is $length")

        var cur = head

        var output = ""
        while(cur?.next != null) {
            output += cur.value.toString() + " --> "
            cur = cur.next!!
        }
        output += cur?.value.toString() + " --> null\n"

        println(output)
    }

    /**
     * Method to reverse the linked list
     */
    fun reverse() {
        var node = head
        var next: Node<T>? = null
        var prev: Node<T>? = null

        while (node != null) {
            next = node.next
            node.next = prev
            prev = node
            node = next
        }

        tail = head!!
        head = prev
    }
}