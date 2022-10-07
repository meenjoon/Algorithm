class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0

        var aa = arrayOf("zero","one","two","three","four","five","six","seven","eight","nine")
        var bb = s

        for(temp in 0..aa.size-1){
            bb = bb.replace(aa[temp],temp.toString())
        }
        answer = bb.toInt()
        return answer
    }
}