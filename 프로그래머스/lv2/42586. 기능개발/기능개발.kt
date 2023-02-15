class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()

        val list = mutableListOf<Int>()

        val resultList = mutableListOf<Int>()

        var current = 0
        var totalCount = 0

        for(index in 0 until progresses.size) {
            if((100-progresses[index])%speeds[index] != 0) {
                list.add((100-progresses[index])/speeds[index] + 1)
            }
            else {
                list.add((100-progresses[index])/speeds[index])
            }
        }

//        list.forEach { println(it) }
//        println()

        for((index,value) in list.withIndex()) {
            if(current == 0 ) {
                current = value
                totalCount++
            }
            else {
                if (current>=value) {
                    totalCount++
                    if(list.lastIndex == index) {
                        resultList.add(totalCount)
                    }
                }
                else {

                    current = value
                    resultList.add(totalCount)
                    totalCount = 1

                    if(list.lastIndex == index) {
                        resultList.add(totalCount)
                    }

                }
            }
        }
        answer = resultList.toIntArray()

//        resultList.forEach { print(it) }

        return answer
    }
}