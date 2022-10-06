class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        answer = arr1.mapIndexed { index, arr -> arr.mapIndexed { index2, value -> arr2[index][index2] + value  }.toIntArray()   }.toTypedArray()
        return answer
    }
}