package leetcode

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
fun main() {
    println(
        RemoveDuplicatesFromSortedArray().removeDuplicates(
            nums = intArrayOf(1, 1, 2)
        )
    )
}

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var index = 1
        for (i in 0 until nums.size - 1) {
            if (nums[i] != nums[i + 1]) {
                nums[index++] = nums[i + 1]
            }
        }
        return index
    }
}