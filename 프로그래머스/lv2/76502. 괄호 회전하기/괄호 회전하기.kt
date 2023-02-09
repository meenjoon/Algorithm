
class Solution {
    fun solution(s: String): Int {
        var answer: Int = -1


        val set = mutableSetOf<Char>()

        val stringBuilder = StringBuilder()

        var totalCount = 0

        var boolean = true


        for(index in 0 until s.length) {
            val a = s.substring(index, s.length) + s.substring(0,index)
//            for(index2 in index until s.length) {
//                    set.add(s[index2])
//            }
//
//            for(index3 in 0..index) {
//                set.add(s[index3])
//            }
//
//            val list = set.toList()


            for(index4 in 0 until a.length) {

                if(stringBuilder.isEmpty()) {
                    stringBuilder.append(a[index4])
                }
                else if(a[index4] == ')' && stringBuilder.last() =='(') {
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
                else if(a[index4] == '}' && stringBuilder.last() =='{') {
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
                else if(a[index4] == ']' && stringBuilder.last() =='[') {
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
                else {
                    stringBuilder.append(a[index4])
                }
            }
//            println("$index $stringBuilder")

            if(stringBuilder.isEmpty()) {
//                println("index : $index")
                totalCount++
            }

//            println(set)
//            set.clear()
            stringBuilder.clear()
        }

//        println(totalCount)

        answer = totalCount

        return answer
    }
}