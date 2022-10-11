class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = n

        val aa = lost.sorted().toSet()-reserve.sorted().toSet()
        val bb = (reserve.sorted().toSet()-lost.sorted().toSet()).toMutableSet()

        for(temp in aa){
            when {
                temp - 1 in bb -> bb.remove(temp - 1)
                temp + 1 in bb -> bb.remove(temp + 1)
                else -> answer--
            }
        }
        return answer
    }
}