class Solution {
    fun solution(s: String): Boolean {
        var answer = true

        for(temp in s){
            if((s.length == 4 || s.length == 6) &&temp.toInt() in  48..57){

            }
            else {
                return false
            }
        }

        return true
    }
}