package myTrees

class BinarySearchTree {
    data class Node (var value: Int, var left: Node? = null, var right: Node? = null)
    private var root: Node? = null

    fun insert(value: Int) {
        val node = Node(value)

        if (root == null) {
            root = node
            return
        }

        var curNode = root
        while(true) {
            if(value < curNode!!.value) {
               if(curNode.left == null ) {
                   curNode.left = node
                   return
               }
               curNode = curNode.left
            } else {
                if(curNode.right == null) {
                    curNode.right = node
                    return
                }
                curNode = curNode.right
            }
        }

    }

    fun lookup(value: Int): Boolean {
        if(root?.value == null ) return false

        var node = root
        while (true) {
            if(node?.value == value) return true

            if (node!!.value > value) {
                if(node?.left == null) return false
                node = node.left
            } else {
                if(node?.right == null) return false
                node = node.right
            }
        }
    }

    fun remove(value: Int): Boolean {
        if(root == null)
            return false

        var currentNode = root
        var parentNode: Node? = null

        while (currentNode != null) {
            if (value < currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.left
            } else if(value > currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.right
            } else if(value == currentNode.value) {
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.left
                        }
                    }
                }

                else if (currentNode.right?.left == null) {
                    if (parentNode == null) {
                        root = currentNode.left
                    } else {
                        currentNode.right?.left = currentNode.left

                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.left
                        }
                    }
                }

                else {
                    var leftmost = currentNode.right?.left
                    var leftmostParent = currentNode.right

                    while (leftmost?.left != null) {
                        leftmostParent = leftmost
                        leftmost = leftmost.left
                    }

                    leftmostParent?.left = leftmost?.right
                    leftmost?.left = currentNode.left
                    leftmost?.right = currentNode.right

                    if (parentNode == null) {
                        root = currentNode.left
                    } else {
                        currentNode.right?.left = currentNode.left

                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.left
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.left
                        }
                    }

                }

                return true
            }
        }

        return false
    }

    fun printTree() {
        println(root)
    }

}