class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var reversenum = 0

        var number = n
        var sb = StringBuilder()

        if(number == 0) {
            answer = 0
        }

        while (number !=0) {
            val remain = number % 3

            if(remain > 9) {
                sb.insert(0, (remain + 55).toChar())
            }
            else {
                sb.insert(0,remain)
            }
            number /= 3
        }

        reversenum = sb.toString().reversed().toInt(3)
        answer = reversenum
        return answer
    }
}