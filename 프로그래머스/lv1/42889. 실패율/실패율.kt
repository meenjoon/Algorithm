class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = IntArray(N)

        val indexMap : MutableMap<Int, Int> = mutableMapOf()
        val failutrMap : MutableMap<Int, Double> = mutableMapOf()


        for((index,element) in stages.withIndex()){

            if(indexMap[element] !=null){
                indexMap[element] = indexMap.getValue(element) + 1
            }
            else {
                indexMap[element] = 1
            }
        }

        var size = stages.size

        for(i in 1..N){
            when(indexMap.containsKey(i)){
                true -> {
                    failutrMap[i] = indexMap.getValue(i) / size.toDouble()
                    size -= indexMap.getValue(i)
                }
                false -> failutrMap[i] = 0.0
            }
        }

        val list = failutrMap.toList().sortedByDescending { (_,value)->value }

        for( i in 0 .. N-1){
            answer[i] = list[i].first
        }
        return answer
    }
}