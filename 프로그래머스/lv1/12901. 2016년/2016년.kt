class Solution {
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var num = 0

        var array = arrayOf(31,29,31,30,31,30,31,31,30,31,30,31)

        if( a!=1) {
            for(a in 0..a-2){
                num +=array[a]
            }
        }

        num = num + b

        answer = when {
            num % 7 == 1 -> "FRI"
            num % 7 == 2 -> "SAT"
            num % 7 == 3 -> "SUN"
            num % 7 == 4 -> "MON"
            num % 7 == 5 -> "TUE"
            num % 7 == 6 -> "WED"
            else -> "THU"
        }
        return answer
    }
}