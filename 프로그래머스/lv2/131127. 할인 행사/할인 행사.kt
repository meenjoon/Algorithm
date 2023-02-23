class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val map = mutableMapOf<String,Int>()

        val list = mutableListOf<String>()



        for(index in 0 until want.size) {
            map.put(want[index],number[index])
        }
//        println(map)

        val sortMap = map.toList().sortedBy { it.second }.toMap()
//        println(sortMap)

        for(index in 0 until discount.size) {
            if (index<=discount.size-10) {
                for (index2 in index..index + 9){
                    list.add(discount[index2])
                }
//                list.forEach { print(it) }
//                println()
//                println(list.size)

                val wantSize = want.size
                var satificCount = 0
                for(mapValue in sortMap) {
                    var count = mapValue.value

                    for(index3 in 0 until list.size) {
                        if(mapValue.key == list[index3]) {
                            count--
                        }
                     }
                    if(count == 0) {
                        satificCount++
                        continue
                    }
                    else{
                        list.clear()
                        break
                    }

                }
                if(satificCount==wantSize) {
                    list.clear()
//                    println("//$index")
                    answer++
                }
            }
            else {
                break
            }

        }


        return answer
    }
}