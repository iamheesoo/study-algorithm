package leetcode

fun main(args: Array<String>) {
    println(
        MergeSortedArray().merge(
            nums1 = intArrayOf(1, 2, 3, 0, 0, 0),
            m = 3,
            nums2 = intArrayOf(2, 5, 6),
            n = 3
        )
    )
}

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        // nums1[m]부터는 0으로 채워진 빈 배열이므로 뒤에서부터 앞으로 값을 넣어야 nums1 값에 덮어씌우지 않는다
        var i1 = m - 1
        var i2 = nums2.lastIndex
        var index = nums1.lastIndex
        while (index >= 0) {
            if (i1 < 0) {
                nums1[index] = nums2[i2--]
            } else if (i2 < 0) {
                nums1[index] = nums1[i1--]
            } else {
                nums1[index] = if (nums1[i1] > nums2[i2]) {
                    nums1[i1--]
                } else {
                    nums2[i2--]
                }
            }

            index--
        }
        println(nums1.contentToString())
    }
}