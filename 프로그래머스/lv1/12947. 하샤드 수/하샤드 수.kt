class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        var input = x
        var result = 0

        while (input != 0) {

            result = result + input % 10
            input = input / 10
        }

        if(x % result == 0) answer=true else answer=false

        return answer
    }
}