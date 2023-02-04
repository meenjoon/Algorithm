class Solution {
    fun solution(s: String): IntArray {
    
        var string = s

        val stringBuilder = StringBuilder()
        s.forEach { stringBuilder.append(it-'0') }

        val stringBuilder_Assistant = StringBuilder()

        var stringBuilder_Length = stringBuilder.length

        var binary_Count = 0
        var totalZeroCount = 0


        while (stringBuilder.length!=1) {

            stringBuilder_Assistant.clear()
            stringBuilder.forEach {
                if((it-'0') == 1) {
                    stringBuilder_Assistant.append(it-'0')
                }
                if((it-'0') == 0) {
                    totalZeroCount++
                }
            }

            if(stringBuilder_Assistant.length == 1) {
                binary_Count++
                break
            }
            stringBuilder_Length = stringBuilder_Assistant.length
            stringBuilder.clear()

            while(stringBuilder_Length !=0) {
                val remain = stringBuilder_Length % 2

                if(remain > 9) {
                    stringBuilder.insert(0, (remain + 55).toChar())
                }
                else {
                    stringBuilder.insert(0, remain)
                }
                stringBuilder_Length /= 2
            }
            binary_Count++
        }



        return intArrayOf(binary_Count,totalZeroCount)
    }
}