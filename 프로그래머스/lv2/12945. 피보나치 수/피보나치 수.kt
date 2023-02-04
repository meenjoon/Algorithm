class Solution {
    fun solution(n: Int): Int {
        var answer = IntArray(n+1) { 1 }

        answer[0] = 0
        answer[1] = 1

        for(index in 2..n) {
            answer[index] = (answer[index-2] + answer[index-1]) % 1234567
        }

        /*
        재귀 방법(메모리 초과)
        */
    //    fun fib(a: Int): Int { 
    //
    //        if(a<=1) {
    //            return a
    //        }
    //
    //        return fib(a-2) + fib(a-1)
    //    }
    //    answer = fib(n) % 123456
       
        /*
        배열 방법(메모리 체적화)
        */
    //    (3..n).forEach { answer[it] = (answer[it-2] + answer[it-1]) % 1234567 }

        // answer.forEach { println(it) }

        return answer[n]
    }
}