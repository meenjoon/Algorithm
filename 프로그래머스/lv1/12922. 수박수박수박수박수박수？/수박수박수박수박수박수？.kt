class Solution {
    fun solution(n: Int): String {
        var answer = ""
        var aa = 0

        if(n == 1 ){
            answer = "수"
        }
        
        else if ( n== 2){
            answer = "수박"
        }
        
        else if(n >3 && n % 2 == 0){
            aa = n - 4
            if(aa ==0){
                answer = "수박수박"
            }
            else {

                answer = "수박수박" + ("수박".repeat(n/2-2))
            }
        }
        else {

            aa = n - 3
            if(aa == 0) {
                answer = "수박수"
            }
            else {
                answer = "수박수" + "박수".repeat(n/2-1)
            }
        }

        return answer
    }
}