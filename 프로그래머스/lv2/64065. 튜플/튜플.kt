class Solution {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()

        val list = mutableListOf<Int>()

        val s_Custum = s.substring(2,s.length-2).split("},{").sortedBy { it.length }
            .forEach { it.split(",").forEach { if(!list.contains(it.toInt())) {
            list.add(it.toInt())}
            } }
//        list.forEach { print(it) }
        
        answer = list.toIntArray()
        return answer
    }
}