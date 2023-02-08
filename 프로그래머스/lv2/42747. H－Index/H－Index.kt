class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        val sortCitations = citations.toList().sorted()

//        sortCitations.forEach { print(it) }

        for(index in 0 until sortCitations.size) {
            val h = sortCitations.size - index

            if(sortCitations[index] >= h) {
                answer = h
                break
            }
        }

        return answer
    }
}