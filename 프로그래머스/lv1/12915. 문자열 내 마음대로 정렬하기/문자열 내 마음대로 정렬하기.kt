class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = arrayOf<String>()

        answer = strings.sorted().sortedBy { it[n] }.toTypedArray()

        return answer
    }
}