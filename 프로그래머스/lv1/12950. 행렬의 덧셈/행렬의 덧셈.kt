class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = Array(arr1.size){IntArray(arr1[0].size)}
        for((index1, element2) in arr1.withIndex()){
            for((index2, element2) in element2.withIndex()){
                answer[index1][index2] = element2 + arr2[index1][index2]
            }
        }
        return answer
    }
}