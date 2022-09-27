import kotlin.math.pow
import kotlin.math.sqrt

class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0


//        if(sqrt(n.toDouble()) % 1 == 0.0) (n+1).toDouble().pow(2) else -1

//        if(sqrt(n.toDouble()) % 1 == 0.0) {
//            answer = (sqrt(n.toDouble()).toLong() + 1).toDouble().pow(2).toLong()
//
//        }
//        else{
//            answer = -1
//        }

        return if(sqrt(n.toDouble()) % 1 == 0.0) (sqrt(n.toDouble()).toLong() + 1).toDouble().pow(2).toLong() else -1
//        return answer
    }
}