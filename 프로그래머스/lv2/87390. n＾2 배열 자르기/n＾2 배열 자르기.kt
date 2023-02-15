class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        val answer = IntArray((right-left).toInt()+1)
        
        for((index,value) in (left..right).withIndex()) {
            val num = Math.max(value % n, value/ n) + 1
            answer[index] = num.toInt()
        }
        
        return answer
    }
}