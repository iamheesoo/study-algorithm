package leetcode

import java.util.Deque
import java.util.LinkedList

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/
 */
fun main() {
    val p = TreeNode(1).apply {
    }

    val q = TreeNode(1).apply {
        right = TreeNode(2)
    }
    println(Solution().isSameTreeDfs(p, q))
}

class Solution {
    fun isSameTreeDfs(p: TreeNode?, q: TreeNode?): Boolean {
        // 값이 다르면 false
        if (p?.`val` != q?.`val`) return false
        // 마지막 노드까지 왔고 값이 같으면 true
        if ((p?.left == null && q?.left == null) && p?.right == null && q?.right == null) return true
        // 내 밑 left, right 이 같은지 확인
        return isSameTreeDfs(p?.left, q?.left) && isSameTreeDfs(p?.right, q?.right)
    }

    fun isSameTreeBfs(p: TreeNode?, q: TreeNode?): Boolean {
        val queue: Deque<Pair<TreeNode?, TreeNode?>> = LinkedList()
        queue.offer(p to q)

        while(queue.isNotEmpty()) {
            val (currentP, currentQ) = queue.poll()
            if (currentP?.`val` != currentQ?.`val`) return false
            if (currentP == null && currentQ == null) continue
            queue.offer(currentP?.left to currentQ?.left)
            queue.offer(currentP?.right to currentQ?.right)
        }
        return true
    }

}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}