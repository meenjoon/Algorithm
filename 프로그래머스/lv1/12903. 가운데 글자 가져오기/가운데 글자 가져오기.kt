class Solution {
    fun solution(s: String): String {
        var answer = ""
        var aa = s.length
        var ss = 0

        if (aa % 2 == 0){
            ss = (aa / 2)
            answer = s[ss-1].toString() + s[ss].toString()
        }
        else{

            ss = (aa / 2)

            answer = s[ss].toString()
        }
        return answer
    }
}