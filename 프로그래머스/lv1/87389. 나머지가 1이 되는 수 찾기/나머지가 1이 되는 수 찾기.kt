import java.util.Collections

class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        val input = n
        var list2 = arrayListOf<Int>()

        for(i in 1..input){
            if ( input % i == 1 ){
                list2.add(i)
            }
        }
        answer = Collections.min(list2)

        return answer
    }
}