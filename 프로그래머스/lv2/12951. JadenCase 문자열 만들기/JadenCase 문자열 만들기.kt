class Solution {
    fun solution(s: String): String {
        var answer = ""
        var upperStringIndex = 0

        val stringBuilder = StringBuilder()

        for((index,value) in s.withIndex()) {

            if(index==0) {
                stringBuilder.append(value.uppercaseChar())
                upperStringIndex = 0
            }
            else if (value==' ') {
                upperStringIndex= index+1
                stringBuilder.append(value)

            }
            else if(upperStringIndex!=0) {
                stringBuilder.append(value.uppercaseChar())
                upperStringIndex = 0

            }
            else {
                stringBuilder.append(value.lowercaseChar())
                upperStringIndex = 0
            }

        }
//        println(stringBuilder.toString())
        answer = stringBuilder.toString()
        return answer
    }
}