package leetcode

fun main(args: Array<String>) {
    println(
        SearchA2dMatrix().searchMatrix(
            matrix = arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60),
            ),
            target = 0
        )
    )
}

class SearchA2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var il = 0
        var ir = matrix.lastIndex
        while (il <= ir) {
            val mid = (il + ir) / 2
            if (matrix[mid][0] == target) return true
            else if (matrix[mid][0] < target) il = mid + 1
            else ir = mid - 1
        }
        val sortArray = matrix.getOrElse(ir) { matrix[0] }.sortedArray()
        var l = 0
        var r = sortArray.lastIndex
        while (l <= r) {
            val mid = (l + r) / 2
            if (sortArray[mid] == target) return true
            else if (sortArray[mid] < target) l = mid + 1
            else r = mid - 1
        }

        return false
    }
}