class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = intArrayOf()
        var array = intArrayOf()
        var list = mutableListOf<Int>()
        var list2 = mutableListOf<Int>()
        var max = 0



        var ee = answers

        var array2 = intArrayOf(1,2,3,4,5)
        var array3 = intArrayOf(2,1,2,3,2,4,2,5)
        var array4 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var aa = answers.size -1

        var ss = aa/5

        var count1 = 0
        var count2 = 0
        var count3 =0

        for((index,element) in answers.withIndex()) {
            ee[index] = element
        }

//        if(ss>1){
//            for((index,element) in (1..ss).withIndex())
//                array = answer.slice(0..4).toIntArray()
//        }
//        for((index,element) in array.withIndex() ){
//            if(array[index] == array2[index]){
//                count1++
//            }
//            if(array[index] == array3[index]){
//                count2++
//            }
//            if(array[index] == array4[index]){
//                count3++
//            }
//        }
        for(index in (0..aa) ){

            if(ee[index] == array2[index % array2.size]){
                count1++
                println("$index count1")
            }
            if(ee[index] == array3[index % array3.size]){
                count2++
                println("$index count2")
            }
            if(ee[index] == array4[index % array4.size]){
                count3++
                println("$index count3")
            }
        }
        list.add(count1)
        list.add(count2)
        list.add(count3)
        max = list.maxOrNull()!!

        if(max == count1){
            list2.add(1)
        }
        if(max == count2){
            list2.add(2)
        }
        if(max == count3){
            list2.add(3)
        }
        println(list2)



        answer = list2.toIntArray()
        println("$count1 $count2 $count3")

//        if(count1 == count2&& count1 == count3 && count2 == count3) {
//            return intArrayOf(1,2,3)
//        }
//        if(count1>)

        return answer
    }
}