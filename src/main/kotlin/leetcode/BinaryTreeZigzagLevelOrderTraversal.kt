package leetcode

import java.util.*


fun main(args: Array<String>) {
    val tree = TreeNode(1).apply {
        left = TreeNode(2).apply { left = TreeNode(4) }
        right = TreeNode(3).apply {
            right = TreeNode(5)
        }
    }
    println(BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(tree))
}

class BinaryTreeZigzagLevelOrderTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        return if (root == null) emptyList()
        else {
            val resultList = mutableListOf<List<Int>>()
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(root)
            var level = 0
            while (queue.isNotEmpty()) {
                val currentLevelNodeSize = queue.size
                val list = mutableListOf<Int>()
                for(i in 0 until currentLevelNodeSize) {
                    val node = queue.poll()
                    list.add(node.`val`)
                    if (node.left != null) queue.offer(node.left)
                    if (node.right != null) queue.offer(node.right)
                }
                if (level %2 !=0) list.reverse()
                resultList.add(list)
                level++
            }
            return resultList
        }
    }
}