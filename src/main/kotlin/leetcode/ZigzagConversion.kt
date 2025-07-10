package leetcode

/**
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
fun main() {
    val s = "PAYPALISHIRING"
    println(ZigzagConversion().convert(s, 4))
}

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        val map = mutableMapOf<Int, MutableList<Char>>()
        /**
         * 1. numRows만큼 리스트 생성
         * 2. s 순회, 어떤 num에 넣을지 변수index 생성
         * 3. index는 0~numRows까지 커졌다가 i == last면 감소를 반복
         * 4. map에서 key차례대로 value뽑아서 string으로 리턴
         */
        repeat(numRows) { num ->
            map[num] = mutableListOf()
        }
        var isPlus = true
        var index = 0
        s.forEach { ch ->
            val list = map.getOrDefault(index, mutableListOf())
            list.add(ch)
            map[index] = list

            if (numRows > 1) {
                if (isPlus) index++ else index--
                if (index == numRows) { // plus해서 범위 초과한 경우
                    index = numRows - 2
                    isPlus = false
                } else if (index < 0) { // minus해서 범위 벗어난 경우
                    index = 1
                    isPlus = true
                }
            } else {
                // index는 항상 0
            }
        }
        val sb = StringBuilder()
        repeat(numRows) { num ->
            sb.append(map[num]?.joinToString(separator = ""))
        }
        return sb.toString()
    }
}