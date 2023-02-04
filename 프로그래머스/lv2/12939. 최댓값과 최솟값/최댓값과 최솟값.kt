class Solution {
    fun solution(s: String): String {
        var answer = ""

        val number_StringBuilder = StringBuilder()

        val numList = ArrayList<Int>()

        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE


        for ((index,value) in s.withIndex()) {
            if (value == ' ') {
                numList.add(number_StringBuilder.toString().toInt())
                number_StringBuilder.clear()
            }
            else if(index == s.length-1) {
                number_StringBuilder.append(value)
                numList.add(number_StringBuilder.toString().toInt())
            }

            else {
                number_StringBuilder.append(value)
            }
        }
//        numList.forEach { println(it) }

        for(value in numList) {
            if(value>=max) {
                max = value
            }
            if(value<=min) {
                min = value
            }
        }
        answer = StringBuilder().append(min).append(" ").append(max).toString()

        return answer
    }
}