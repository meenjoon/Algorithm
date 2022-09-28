class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0

        if(a>b) {
            for(i in b..a){
                answer = answer + i
            }
        }
        else {
            for (i in a.. b){
                answer = answer + i
            }
        }

        return answer
    }
}