class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        var priorities_IndexValue = priorities.withIndex().toMutableList()

        var count = 0

        while (priorities_IndexValue.isNotEmpty()) {
            val first_Value = priorities_IndexValue.first()
            priorities_IndexValue.removeAt(0)

            if(priorities_IndexValue.any{first_Value.value<it.value}) {
                priorities_IndexValue.add(first_Value)
                continue
            }
            count++
            if(first_Value.index==location) {
                break
            }

        }
        answer = count
        
        return answer
    }
}