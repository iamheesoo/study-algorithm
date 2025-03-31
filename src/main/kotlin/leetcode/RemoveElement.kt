package leetcode

fun main(args: Array<String>) {

    println(
        RemoveElement().removeElement(
            nums = intArrayOf(3, 2, 2, 3),
            `val` = 3
        )
    )
}

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        for(i in nums.indices) {
            if (nums[i] != `val`) {
                nums[index++] = nums[i]
            }
        }
        return index
    }
}