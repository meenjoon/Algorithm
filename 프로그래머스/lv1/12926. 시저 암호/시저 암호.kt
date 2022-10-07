class Solution {
    fun solution(s: String, n: Int): String {
        var answer = ""
        answer = s.split(" ").joinToString(" ").map {
           when(it) {
                in 'A'..'Z' ->{
                    if('Z'< it+n) it+n-26 else it+n
                }

               in 'a'..'z' -> {
                   if('z'< it+n) it+n-26 else it+n
               }
               else -> {
                   it
               }
          }
        }.joinToString("")

        return answer
    }
}