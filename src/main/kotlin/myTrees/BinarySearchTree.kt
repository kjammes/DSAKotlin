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

    fun breadthFirstSearch(value: Int): Boolean {
        var visited = mutableSetOf<Int>()
        var traverseOrder = mutableListOf<Int>()
        var queue = ArrayList<Node?>()
        var curNode = root
        queue.add(curNode)
        var result = false
        while (queue.isNotEmpty()) {
            curNode = queue.removeAt(0)
            if (curNode?.value == value)
                result = true
            visited.add(curNode!!.value)
            traverseOrder.add(curNode?.value)
            if(curNode?.left != null) {
                queue.add(curNode.left)
            }
            if(curNode?.right != null) {
                queue.add(curNode.right)
            }
        }
        println(visited)
        return result
    }

    private fun bfsRecursion(queue: ArrayList<Node?>, visited: MutableSet<Int>, value: Int): Boolean {
        if(queue.size == 0) {
            println("Visited nodes while traversing $visited")
            return false
        }
        val curNode = queue.removeAt(0)
        visited.add(curNode!!.value)
        if (curNode?.value == value) {
            println("Visited nodes while traversing $visited")
            return true
        }
        if (curNode?.left != null)
            queue.add(curNode.left)
        if (curNode?.right != null)
            queue.add(curNode.right)

        return bfsRecursion(queue, visited, value)
    }

    fun bfsR(value: Int): Boolean {
        var q = ArrayList<Node?>()
        q.add(root)
        var s = mutableSetOf<Int>()
        return bfsRecursion(q, s, value)
    }

    fun depthFirstSearch(value: Int): Boolean {
        var visited = mutableSetOf<Int>()
        var queue = ArrayList<Node?>()
        var curNode = root
        queue.add(curNode)
        var result = false
        while (queue.isNotEmpty()) {
            curNode = queue.removeAt(queue.size - 1)
            if (curNode?.value == value)
                result = true
            visited.add(curNode!!.value)
            if(curNode?.left != null) {
                queue.add(curNode.left)
            }
            if(curNode?.right != null) {
                queue.add(curNode.right)
            }
        }
        println(visited)
        return result
    }

    fun inorder(node: Node?, result: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            inorder(node.left, result)
        }
        result.add(node?.value)
        if (node?.right != null) {
            inorder(node.right, result)
        }
        return result
    }

    fun preOrder(node: Node?, result: ArrayList<Int?>): ArrayList<Int?> {
        result.add(node?.value)
        if (node?.left != null) {
            preOrder(node.left, result)
        }
        if (node?.right != null) {
            preOrder(node.right, result)
        }
        return result
    }

    fun preOrderR(node: Node?) {

        if(node == null)
            return

        val stack = ArrayList<Node?>()
        stack.add(node)
        while (stack.isNotEmpty()) {
            var cur = stack.removeAt(stack.size-1)
            println(cur?.value)
            if(cur?.left != null)
                stack.add(cur.left)
            if(cur?.right != null)
                stack.add(cur.right)
        }
    }

    fun inOrderR(node: Node?) {
        if(node == null)
            return

        var cur = node
        val stack = ArrayList<Node?>()
        stack.add(cur)
        while (stack.size > 0 && cur != null) {

            while (cur != null) {
                stack.add(cur)
                cur = cur?.left
            }

            cur = stack.removeAt(stack.size-1)

            println(cur?.value)

            cur = cur?.right

        }
    }

    fun postOrder(node: Node?, result: ArrayList<Int?>): ArrayList<Int?> {
        if (node?.left != null) {
            postOrder(node.left, result)
        }
        if (node?.right != null) {
            postOrder(node.right, result)
        }
        result.add(node?.value)
        return result
    }

    fun printTree() {
        println(root)
    }

    fun getRootRef(): Node? {
        return root
    }

}