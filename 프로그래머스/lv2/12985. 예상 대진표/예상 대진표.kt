class Solution {
   fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var a_num = a
        var b_num = b
        var count = 0

        while (true) {
            a_num = a_num / 2 + a_num % 2
            b_num = b_num /2 + b_num % 2
            count++
            if(a_num == b_num) {
                break
            }
        }
        answer = count

        return answer
    }
}