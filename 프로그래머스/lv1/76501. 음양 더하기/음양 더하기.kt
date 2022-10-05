class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        val answer: Int = 123456789
        val array = arrayOfNulls<Int>(absolutes.size)
        var ss: Int = 0

        for((temp, tempss) in absolutes.withIndex()) {
            val i: Int = 0
//            println("aaa $tempss")

            if(signs[temp]){
                array[temp] = tempss
            }
            else{
                array[temp] = -tempss
            }
        }

        for(aaa in array){
            if (aaa != null) {
                ss+=aaa
                println(ss)
            }
        }


        return ss
    }
}