package myTrees

fun main() {

    var bst = BinarySearchTree()

//    bst.insert(4)
//    bst.insert(6)
//    bst.insert(5)
//    bst.insert(3)
//    bst.insert(2)
//
//    bst.printTree()
//    println(bst.lookup(9))
//    println(bst.lookup(4))
//    println("BFS traversal for 5 " + bst.breadthFirstSearch(5))
//    println("BFS recursion traversal for 5 " + bst.bfsR(5))
//    println("DFS traversal for 5 " + bst.depthFirstSearch(5))
//    println("Remove success for 5 " + bst.remove(5))
//    println("BST traversal for 5 " + bst.breadthFirstSearch(5))
//    println("Remove success for 5 again " + bst.remove(5))
//
//    println("Inorder traversal = ${bst.inorder(bst.getRootRef(), ArrayList<Int?>())}")
//    println("Pre order traversal = ${bst.preOrder(bst.getRootRef(), ArrayList<Int?>())}")
//    println("Post order traversal = ${bst.postOrder(bst.getRootRef(), ArrayList<Int?>())}")

    bst.insert(9)
    bst.insert(4)
    bst.insert(6)
    bst.insert(20)
    bst.insert(170)
    bst.insert(15)
    bst.insert(1)

    println("BFS ${bst.bfsR(170)}")
    println("BFS ${bst.depthFirstSearch(170)}")

}