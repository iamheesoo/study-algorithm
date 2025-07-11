package leetcode

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
 */
fun main(args: Array<String>) {
    println(
        Dp392().isSubsequence(
            s = "ad",
            t = "casdf"
        )
    )

}

class Dp392 {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length > t.length) return false
        var sIndex = 0
        var tIndex = 0
        while(tIndex < t.length) {
            if (s[sIndex] == t[tIndex]) sIndex++
            if (sIndex >= s.length) {
                return true
            }
            tIndex++
        }
        return false
    }
}