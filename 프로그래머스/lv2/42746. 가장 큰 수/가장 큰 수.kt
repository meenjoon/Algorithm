
class Solution {
    fun solution(numbers: IntArray): String {
        /**
         * answer를 "0"으로 초기화 한 이유는 만약 input으로 [0,0,0,0]이 들어왔을때
         * stringArray는 0000이 될텐데, stringArray[0] = "0" 이라는 조건을 내세요 현재 answer인 값인 "0"을 리턴한다.
         * 그리고 참고로 stringArray[0] = "0" 즉, 제일 첫째자리의 값이 0이라면 그 값은 0인 값이다.
         */
        var answer = "0"

        var stringArray = arrayOf<String>() //String 배열 생성

        for(index in 0 until numbers.size) {
            stringArray += numbers[index].toString() //stringArray에 numbers의 각 인덱스에 해당하는 값을 넣어준다.
        }
//        stringArray.forEach { print(it) }
//
//        println()

        /**
         * Comparator는 컬렉션에 대해 순서를 부과한다.
         * 그렇다면 어떻게 순서를 부과하냐면..
         * ==> o1, o2를 매개변수로 받아서 비교를 하게 되는데ㅐ o1과 o2는 인덱스(0,1)의 값, 인덱스(1,0)의 값과 같이 2개씩 비교를 하는데, 인덱스 0의 값부터 마지막 인덱스의 값까지 o1, o2로 비교한다는 것이다.
         * 그렇다면 o1, o2의 2개의 값을 순차적으로 어떻게 비교를 하냐면,
         * compareTo를 통해 비교를 하게 되는데,
         * 이때 String의 값을 서로 비교를 해줘야한다는 점이 중요하고,
         * 뒤에 있는 수 즉, o2를 기준으로 앞에 있는 수 o1을 비교해줘야한다.
         * 왜냐하면 뒤에 있는 수로 비교를 해줘야 계속해서 앞에 있는 수와 뒤에 있는 수의 차이를 비교 할 수 있기 때문이다.
         * 그렇게 하게 되면 앞과 뒤의 차이의 값이 나오는데 계속해서 앞과 뒤의 값을 비교하기때문에 서로 앞 뒤 연관이 있기 때문에
         * 그 값들의 차이들을 이용하여 나열을 해서 그 값들의 순위를 매겨서 정렬을 하는 것이다.
         *
         * 그리고 또한 만약 o1과 o2의 길이가 다르다면 o2와 o1을 더한 값과 o1과 o2를 더한 값을 비교한다.
         * 예를 들어 설명해보자면, 5와 10을 그냥 비교하면 10이 더 크기 때문에 정렬은 10,5가 나오고 이걸 나중에 붙이면 105가 나오게 된다.
         * 그러나 10와 5를 반대로 붙이면 105가 아닌 510이 더 큰 거처럼 예외가 발 생할 수 있기 때문에 두 개의 문자열을 더해서 비교해야 한다.
         */

        stringArray.sortWith(Comparator{o1,o2 ->
            if(o1.length == o2.length) {
                o2.compareTo(o1)
            } else {
                (o2+o1).compareTo(o1+o2)
            }
        })
//        stringArray.forEach { print(it) }

        if(stringArray[0]=="0") {
            return answer
        } else {
            answer = ""
            for (index in 0 until stringArray.size) {
                answer+=stringArray[index]
            }
        }
        return answer
    }
}

//fun main() {
//    val solutionInstance = Solution()
//    solutionInstance.solution(intArrayOf(0, 0, 0, 0))
//}