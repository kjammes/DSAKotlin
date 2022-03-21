package stackQueue

fun main() {

//    var stack = ArrStack<String>()
//    stack.push("google")
//    stack.push("udemy")
//    stack.push("youtube")
//    stack.printStack()
//    println(stack.pop())
//    stack.printStack()

    val q = MyQueue<String>()
    q.peek()
    q.dequeue()
    q.enqueue("Jayesh")
    q.enqueue("John")
    q.enqueue("Paul")
    q.print()
    println(q.peek())
    println(q.dequeue())
    q.print()
}