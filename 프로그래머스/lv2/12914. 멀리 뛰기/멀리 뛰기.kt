class Solution {
    fun solution(n: Int): Long {
        var answer: Long = 0

        val array = LongArray(n+1)
        if(n == 1 ) {
            return 1
        }
        if(n == 2 ) {
            return 2
        }
        if(n == 3) {
            return 3
        }
        
        array[2] = 2
        array[3] = 3

        for(index in 4..n) {
            array[index] = (array[index-1] + array[index-2]) % 1234567
        }

        answer = array[n]

        return answer
    }
}