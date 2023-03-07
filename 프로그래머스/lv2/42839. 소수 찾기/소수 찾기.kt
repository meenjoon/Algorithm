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


//  fun solution(name: String): Int {
//         var answer = 0

//         val stringBuilder = StringBuilder()

//         val set = mutableSetOf<String>()

//         val visited = BooleanArray(name.length)

//         /**
//          * dfs 함수로 구현한 순열(순서 있는 조합)
//          * 초기에 미리 설정해놓을 것은,
//          * 1-1. visited 라는 BooleanArray를 구하려는 값의 length만큼 사이즈를 할당하여 생성한다.
//          * 1-2. 데이터를 넣을 stringBuilder를 생성한다.
//          * 1-3. 중복이 불가능하게 Set 컬렉션을 생성한다.
//          */
//         fun dfs(depth: Int) {
//             if(depth == name.length) { //만약 탐색하는 깊이가 구하려는 값의 length와 같다면
//                 if(stringBuilder.toString() != "") { //stringBuilder의 값이 공백이 아니라면
//                     set.add(stringBuilder.toString()) //만들어둔 Set 컬렉션에 stringBuilder의 값을 추가한다.
//                     return //리턴
//                 }
//                 else { //stringBuilder의 값이 공백이라면 바로 리턴
//                     return
//                 }
//             }
//             for(index in 0 until name.length) { //0부터 구하려는 값의 사이즈 만큼 반복한다.
//                 if (!visited[index]) { //만약 현재 인덱스가 방문하지 않은 인덱스라면
//                     visited[index] = true //현재 인덱스를 방문처리를 한다.
//                     stringBuilder.append(name[index]) //현재 구하려는 값의 인덱스 위치에 있는 값을 stringBuilder에 추가한다.
//                     dfs(depth + 1) //현재 깊이의 +1 만큼의 재귀함수 호출
//                     visited[index] = false //재귀함수 빠져나갔으니 다시 방문을 하지 않았다고 한다.
//                     stringBuilder.deleteCharAt(stringBuilder.length-1)//stringBuilder의 마지막 값을 삭제한다.
//                     dfs(depth + 1) //현재 깊이의 +1 만큼의 재귀함수 호출
//                 }
//             }
//         }
//         dfs(0)

//         set.forEach { println(it) } //함수 확인

//         return answer
//     }