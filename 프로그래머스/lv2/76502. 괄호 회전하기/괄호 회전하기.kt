class Solution {
    fun solution(s: String): Int {
        var answer: Int = -1

        val stringBuilder = StringBuilder()

        var totalCount = 0

        for(index in 0 until s.length) {

            val s_Roatate = s.substring(index, s.length) + s.substring(0,index) // 회전한 문자열
//            println("${s.substring(index, s.length)} ${s.substring(0,index)}")

            for(index4 in 0 until s_Roatate.length) { //짝이 맞으면 지우는 로직이고, 짝이 맞지 않으면 stringBuilder에 짝이 맞지 않는 괄호들이 남기 때문에 이부분을 통해 isEmpty()를 이용해 올바른 괄호 문자열을 판별한다.

                if(stringBuilder.isEmpty()) {
                    stringBuilder.append(s_Roatate[index4])
                }
                else if(s_Roatate[index4] == ')' && stringBuilder.last() =='(') {
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
                else if(s_Roatate[index4] == '}' && stringBuilder.last() =='{') {
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
                else if(s_Roatate[index4] == ']' && stringBuilder.last() =='[') {
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
                else {
                    stringBuilder.append(s_Roatate[index4])
                }
            }
            if(stringBuilder.isEmpty()) {
                totalCount++
            }

            stringBuilder.clear()
        }

        answer = totalCount

        return answer
    }
}