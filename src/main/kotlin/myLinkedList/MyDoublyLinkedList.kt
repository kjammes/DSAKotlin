package myLinkedList

class MyDoublyLinkedList<T> (private val value: T) {
    data class Node<T> (var value: T, var next: Node<T>? = null, var prev: Node<T>? = null)
    private var head: Node<T>? = Node(value)
    private var tail: Node<T>? = head
    private var length = 1

    /**
     * Takes a valid index as input and returns the Node at that index in LinkedList
     */
    private fun getNodeAt(index: Int): Node<T> {
        var cur = if(index < length / 2) head else tail

        if(index < length / 2) {
            var curInd = 0

            while (curInd++ != index && cur?.next != null) {
                cur = cur.next
            }
        } else {
            var curInd = length - 1

            while (curInd-- != index && cur?.prev != null) {
                cur = cur.prev
            }
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
        node.prev = tail
        tail?.next = node
        tail = node
        length++
    }

    /**
     * Inserts value at the head of LinkedList
     */
    fun insertAtHead(value: T) {
        val node = Node(value)
        node.next = head
        head?.prev = node
        head = node
        length++
    }

    /**
     * Inserts a value at a given index in LinkedList(assuming valid index)
     */
    fun insertAt(index: Int, value: T) {
        if ( !isValidIndex(index) ) return
        length++

        if(index == 0) {
            insertAtHead(value)
            return
        }

        if(index == length - 1) {
            insert(value)
            return
        }

        val lead = getNodeAt(index - 1)
        val trail = lead.next

        val node = Node(value)
        lead.next = node
        node.prev = lead
        node.next = trail
        trail?.prev = node
    }

    /**
     * Removes an element from the given index(assuming valid index)
     */
    fun remove(index: Int) {
        if ( !isValidIndex(index) ) return
        length--

        if(index == 0) {
            head = head?.next
            head?.prev = null
            return
        }

        if(index == length - 1) {
            tail = tail?.prev
            tail?.next = null
            return
        }

        val lead = getNodeAt(index - 1)
        val toBeDeleted = lead.next
        lead.next = toBeDeleted?.next
        lead.next?.prev = lead
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
     * Prints all the elements in the LinkedList in reverse order
     */
    fun printAllReversed() {
        println("Printing in REVERSE")
        println("Head is ${head?.value}, tail is ${tail?.value} & length of linked list is $length")

        var cur = tail

        var output = "null <-- "
        while(cur?.prev != null) {
            output += cur.value.toString() + " <-- "
            cur = cur.prev
        }
        output += cur?.value.toString() + "\n"

        println(output)
    }
}