package leetcode

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description/
 */
fun main() {
    val s = "MCMXCIV"
    println(RomanToInteger().romanToInt(s))
}

class RomanToInteger {
    fun romanToInt(s: String): Int {
        var answer = 0
        for (i in s.indices) {
            val digit = charToInt(s[i])
            if (i == s.lastIndex || digit >= charToInt(s[i + 1])) {
                answer += digit
            } else {
                answer -= digit
            }
        }
        return answer
    }

    fun charToInt(ch: Char): Int {
        return when (ch) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
    }
}