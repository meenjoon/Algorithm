import kotlin.math.*

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0

        val stringBuilder = StringBuilder()

        var number = n
        var digit = k

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

        primeNumber()

        val stringBuilderCustum = stringBuilder.toString().split("0")

//        var maxNum = 0L
//
//        stringBuilderCustum.forEach { if(it.isNotEmpty()&&it.toInt()>=maxNum) {
//            maxNum=it.toLong()
//        } }

//        val booleanArray = BooleanArray(maxNum+1){true}
//        booleanArray[0] = false
//        booleanArray[1] = false
//
//        val sqrtOfMaxNum = sqrt(maxNum.toDouble()).toInt()
//
//        for (index in 2..sqrtOfMaxNum) {
//            if(booleanArray[index]==false){
//                continue
//            }
//
//            var j = 2
//
//            while (index*j<=maxNum) {
//
//                if(booleanArray[index*j]) {
//                    booleanArray[index*j] = false
//                }
//                j++
//            }
//        }
//        booleanArray[2] = true
//
//        for((index,value) in stringBuilderCustum.withIndex()) {
//
//            if(value.isNotEmpty() && booleanArray[value.toInt()] == true) {
////                println(value)
//                answer++
//            }
//        }
////        println(answer)

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


        for((index,value) in stringBuilderCustum.withIndex()) {
            if(value.isNotEmpty() && isPrime(value.toLong())) {
                answer++
            }
        }

        println(answer)

        return answer
    }
}