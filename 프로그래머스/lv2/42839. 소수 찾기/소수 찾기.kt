class Solution {
    fun solution(numbers: String): Int {
        var answer = 0

        var stringBuilder = StringBuilder() //값 저장을 위한 stringBuilder
        val set = mutableSetOf<Int>() //소수 판별한 값을 넣기 위한 set 컬렉션
        var check = BooleanArray(numbers.length) //방문처리를 위한 배열

        /**
         * 소수 판별 함수
         */
        fun isPrime(number: Int): Boolean{
            if(number <= 1) {
                return false
            }
            for (index in 2 until number) {
                if (number % index == 0) {
                    return false
                }
            }
            return true
        }

        /**
         * 모든 조합을 찾을 수 있는 함수
         */
        fun search(depth: Int) {
            // println("depth : $depth stringBuilder : ${stringBuilder.toString()}")
            /**
             * 깊이가 최대 길이 일 때 리턴을 해준다.
             * 만약 stringBuilder가 공백이 아니며, 소수판별 함수로 인해 소수이면 set컬렉션에 값을 추가한다.
             */
            if (depth == numbers.length) { //
                if(stringBuilder.toString() != ""){ 
//                    println("///depth : $depth stringBuilder : ${stringBuilder.toString()}")
                    /**
                     * //Int 형태로 바꾸는 이유는 011의 값을 11로 만들어주기 때문이다.
                     */
                    if(isPrime(stringBuilder.toString().toInt())) {
                        set.add(stringBuilder.toString().toInt())
//                        println(set)
                    }
                }
//                println("///depth : $depth stringBuilder : ${stringBuilder.toString()}")
                return
            }

            for(index in 0 until numbers.length) {
                if(!check[index]) { //만약 방문하지 않은 노드라면
                    check[index] = true //방문했다고 다시 설정
                    stringBuilder.append(numbers[index]) //현재 인덱스에 해당하는 number의 값을 stringBuilder에 추가한다.
                    search(depth+1) //재귀함수 호출
                    check[index] = false //방문하지 않았다고 다시 설정
                    stringBuilder.deleteCharAt(stringBuilder.length-1) //stringBuilder의 마지막 값 삭제
                   search(depth+1) //다시 재귀함수 호출
                }
            }
        }
        search(0)
//        println(set)

        answer = set.size

        return answer
    }
}