package leetcode

fun main(args: Array<String>) {
    println(SearchInsertPosition().searchInsert(nums = intArrayOf(1, 3), target = 2))
}

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        var mid = 0
        while (l <= r) {
            mid = (l + r) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return l
    }
}