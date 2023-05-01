class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        
        val answer = IntArray((right-left).toInt()+1)

        /* 방법1.
         */
//        for((index,value) in (left..right).withIndex()) {
//            val num = Math.max(value % n, value/ n) + 1
//            answer[index] = num.toInt()
//        }

        /* 방법2.
        */
        (left..right).mapIndexed { index, value ->
            val a = Math.max(value % n,value / n) + 1
            answer[index] = a.toInt()
        }
        return answer
    }
}