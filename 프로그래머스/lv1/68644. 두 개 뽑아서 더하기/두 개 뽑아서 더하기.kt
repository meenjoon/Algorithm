class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        var set = mutableSetOf<Int>()

        for(i in 0..numbers.size-1){
            for(j in i+1..numbers.size-1){
                set.add(numbers[i]+numbers[j])
            }
        }
        answer = set.sorted().toIntArray()

        return answer
    }
}