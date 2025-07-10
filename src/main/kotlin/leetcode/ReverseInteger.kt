package leetcode

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 */
fun main() {
    val s = -321
    println(ReverseInteger().reverse(s))
}

class ReverseInteger {
    fun reverse(x: Int): Int {
        val isMinus = x<0
        val num = if (isMinus) x*-1 else x
        val result = num.toString().reversed().toIntOrNull() ?: 0
        return if (isMinus) result * -1 else result
    }
}