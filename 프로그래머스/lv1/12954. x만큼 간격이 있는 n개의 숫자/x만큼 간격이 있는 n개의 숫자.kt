class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = longArrayOf()
        var nn = n
        var rr = arrayListOf<Long>()

        for(i in 1..nn) {
            var pp = (i.toLong() * x.toLong())
            rr.add(pp)
        }
        answer = rr.toLongArray()

        return answer
    }
}