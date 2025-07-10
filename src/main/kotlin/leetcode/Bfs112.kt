package leetcode

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs
import kotlin.math.max

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/description/?envType=problem-list-v2&envId=depth-first-search
 */

fun main(args: Array<String>) {
//    val tree = TreeNode(3).apply {
//        left = TreeNode(9)
//        right = TreeNode(20).apply {
//            left = TreeNode(15)
//            right = TreeNode(7)
//        }
//    }
//    val tree = TreeNode(1).apply {
//        left = TreeNode(2).apply {
//            left = TreeNode(3).apply {
//                left = TreeNode(4)
//                right = TreeNode(4)
//            }
//            right = TreeNode(3)
//        }
//        right = TreeNode(2)
//    }
    val tree = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    println(Bfs112().hasPathSum(tree, 5))
}

class Bfs112 {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        return bfs(root, targetSum)
    }

    fun dfs(node: TreeNode?, targetSum: Int): Boolean {
        if (node == null) return false
        if (node.left == null && node.right == null) return node.`val` == targetSum
        return dfs(node.left, targetSum-node.`val`) || dfs(node.right, targetSum-node.`val`)
    }

    fun bfs(node: TreeNode?, targetSum: Int): Boolean {
        if (node == null) return false
        val q: Queue<Pair<TreeNode, Int>> = LinkedList()
        q.offer(node to targetSum)
        while(q.isNotEmpty()) {
            val (current, sum) = q.poll()
            if (current.left == null && current.right == null) {
                if (current.`val` == sum) return true
            } else {
                val subtract = sum-current.`val`
                current.left?.let { q.offer(it to subtract) }
                current.right?.let { q.offer(it to subtract)}
            }
        }
        return false
    }
}