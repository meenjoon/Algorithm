class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        var answer = intArrayOf()

        for (num in arr){
            if(num % divisor ==0) {
                answer = answer + num
            }
        }
        answer.sort()

        if(answer.isEmpty()) {
            answer = answer + -1
        }

        return answer
    }
}