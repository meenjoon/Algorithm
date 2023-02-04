class Solution {
    fun solution(n: Int): Int {
        var answer = IntArray(n+1) { 1 }

    //    fun fib(a: Int): Int {
    //
    //        if(a<=1) {
    //            return a
    //        }
    //
    //        return fib(a-2) + fib(a-1)
    //    }
    //    answer = fib(n) % 123456

        (3..n).forEach { answer[it] = (answer[it-2] + answer[it-1]) % 1234567 }

        // answer.forEach { println(it) }

        return answer[n]
    }
}