package myTrees

fun main() {

    var bst = BinarySearchTree()

    bst.insert(4)
    bst.insert(6)
    bst.insert(5)
    bst.insert(3)
    bst.insert(2)

    bst.printTree()
    println(bst.lookup(9))
    println(bst.lookup(4))
    println("Remove success for 5 " + bst.remove(5))
    println("Remove success for 5 again " + bst.remove(5))

}