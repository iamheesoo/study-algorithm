package leetcode

import java.util.LinkedList
import java.util.Queue

/**
 * 99. Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 */
fun main() {
    val tree = TreeNode(1).apply {
        left = TreeNode(3).apply {
            right = TreeNode(2)
        }
    }
    println(RecoverBinarySearchTree().recoverTree(tree))
}

class RecoverBinarySearchTree {
    var index = 0
    fun recoverTree(root: TreeNode?): Unit {
        // 트리를 BFS로 list로 변경했을 때 오름차순이 되야 한다
        // bfs로 list를 만들고 걔를 오름차순으로 변경한다
        // 다시 bfs로 돌면서 list[i]와 다르면 swap
        val list = LinkedList<Int>()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.offer(root)
        while(queue.isNotEmpty()) {
            val node = queue.poll()
            if (node?.`val` != null) {
                list.add(node.`val`)
                queue.offer(node.left)
                queue.offer(node.right)
            }
        }
        list.sort()

        // tree를 중위순회
        inorder(root, list)
        println(root)
    }
    fun inorder(root: TreeNode?, list: List<Int>) {
        if (root?.left != null) inorder(root.left , list)
        if (root != null) {
            if (root.`val` != list[index]) root.`val` = list[index]
            index++
        }
        if (root?.right != null) inorder(root.right, list)
    }
}