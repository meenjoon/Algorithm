class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0

        var total = 0

        for(ll in left..right){
            var count = 0

            for(temp in 1..ll){
                if(ll % temp ==0 ){
                    count++
                    println("약수 갯수 ${count}")
                }
            }
            if(count% 2==0){ //짝수라면
                println("짝수 : ${total}")
                total+=ll
            }
            else { //홀수라면
                println("홀수 : ${total}")
                total-=ll
            }
        }
        return total
    }
}