class Solution {
    fun solution(numbers: IntArray): Int {
        
        var answer: Int = -1
        var ss = 0
        var total = 0
        for(temp in numbers) {
            ss += temp
        }

        for(x in 1..9){
            total += x
        }
        answer = total-ss

        return answer
    }
}