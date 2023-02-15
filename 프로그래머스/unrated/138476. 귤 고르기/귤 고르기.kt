class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {

        tangerine.sort()
        var answer: Int = 0

        var current_Value = k
        var before_Value = 0

        var totalCount = 0

        val map = mutableMapOf<Int,Int>()

        val list = mutableListOf<Int>()


        for(index in 0 until tangerine.size) {
            map.put(tangerine[index],map.getOrDefault(tangerine[index],0)+1)
        }

        val map_Custom = map.toList().sortedByDescending { it.second }.toMap()

        for(value in map_Custom) {
            for(index in 1..value.value) {
                list.add(value.key)
            }
        }

//        list.forEach { print(it) }

        println()

        for(index in 0 until list.size) {
            for(index2 in index until list.size) {

                current_Value = current_Value-1
                if(before_Value!=list[index2]) {
                    totalCount++
                }
//                println("$index $index2 $current_Value")

                if(current_Value==0) {
                    println(totalCount)
                    return totalCount
                }
//                if(current_Value<0) {
//                    totalCount--
//                    current_Value = current_Value+list[index2]
//                }

                before_Value = list[index2]
            }
        }
        return totalCount
    }
}