package myLinkedList

fun main() {
    val myLinkedList = MyLinkedList<Int>(5)

    myLinkedList.printAll()
    myLinkedList.insert(2)
    myLinkedList.insert(4)
    myLinkedList.insert(2)
    myLinkedList.insert(1)
    myLinkedList.printAll()
    myLinkedList.insertAtHead(100)
    myLinkedList.printAll()
    myLinkedList.insertAt(3, 300)
    myLinkedList.printAll()
    myLinkedList.insertAt(52,32)
    myLinkedList.remove(3)
    myLinkedList.printAll()
    myLinkedList.reverse()
    myLinkedList.printAll()
}
