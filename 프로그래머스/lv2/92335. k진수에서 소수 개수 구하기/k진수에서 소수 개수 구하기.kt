import kotlin.math.*

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        val stringBuilder = StringBuilder() //진법을 변환한 것을 stringBuilder에 insert함

        var number = n
        var digit = k

        //진법 변환 함수
        fun primeNumber() {
            while (number!=0) {
                val remain = number % digit
                if(remain>9) {
                    stringBuilder.insert(0,(55+remain).toChar())
                }
                else {
                    stringBuilder.insert(0,remain)
                }
                number /=digit
            }
        }

        primeNumber() //진법 변환함수 호출을 하여 stringBuilder에 진법 변환값을 부여한다.

        //진법 변환한 stringBuilder를 split을 이용해 0으로 자른다. split을 이용한 이유는 배열로 잘라주기 때문
        val stringBuilderCustum = stringBuilder.toString().split("0")

        /*
        이 문제에서는 원하는 수에 대해서 소수를 판명해야한다.(범위는 제곱근을 필수로 이용을 해야한다.)
        만약 에라토스테네스를 이용해 2부터 최댓값까지 적용을 시키면 메모리 초과가 난다.
        아래는 원하는 소수를 판명할 수 있는 소수 판명 함수인데 주의할 점은 매개변수로 Long 타입을 받아야한다는 점이다.
         */
        fun isPrime(num: Long) : Boolean {
            if (num<2) {
                return false
            }
            if(num==2L) {
                return true
            }
            for(index in 2..sqrt(num.toDouble()).toLong()) {
                if((num%index) == 0L) {
                    return false
                }
            }
            return true
        }

        /*
        stringBuilderCustum은 내가 소수로 판명해야 할 값이 있는 list이다.(split으로 잘랐기 때문에)
        주의해야할 점으로 0으로 split을 이용해 자를때 ""와 같이 비어있는 값도 존재하기 때문에 비어있는지 확인을 해줘야 한다.
        또한 주의해야할 점으로는 소수를 판명할 때 Long 타입을 줘야하기 때문에 Long타입으로 변환하여 값을 넘겨준다.
        Long타입으로 해야하는 이유는 최대 100만이라는 숫자를 N진법 변환을 하면 엄청난 길이의 숫자로 나열되고, int의 범위를 넘어서는 숫자가 생성되기 때문이다.
        */
        for((index,value) in stringBuilderCustum.withIndex()) {
            if(value.isNotEmpty() && isPrime(value.toLong())) {
                answer++
            }
        }
        return answer
    }
}