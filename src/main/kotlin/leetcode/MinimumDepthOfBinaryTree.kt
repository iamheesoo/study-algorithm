package leetcode

import java.util.*


fun main(args: Array<String>) {
    val tree = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(MinimumDepthOfBinaryTree().minDepth(tree))
}

class MinimumDepthOfBinaryTree {
    fun minDepth(root: TreeNode?): Int {
        val queue: Queue<Pair<TreeNode?, Int>> = LinkedList()
        if (root != null) {
            queue.offer(root to 1)
            while (queue.isNotEmpty()) {
                val (node, count) = queue.poll()
                if (node?.left == null && node?.right == null) {
                    return count
                }
                if (node.left != null) {
                    queue.offer(node.left to count + 1)
                }
                if (node.right != null) {
                    queue.offer(node.right to count + 1)
                }
            }
        }
        return 0
    }
}