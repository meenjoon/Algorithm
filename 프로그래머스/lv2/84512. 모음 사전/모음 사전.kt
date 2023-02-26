class Solution {
    fun solution(word: String): Int {
        var answer = 0

        /**
         * 방법 1. 재귀함수 이용
         */
        val stringBuilder = StringBuilder()
        val aeiouList = listOf<String>("A","E","I","O","U")
        var isSame = false
        var count = 0
        fun dfs(depth: Int, target: String) {
            if (stringBuilder.length > 5) { // stringBuilder의 크기가 5보다 크면 더 넣으면 안되기 때문
                return
            }
            if(stringBuilder.toString()== target) { // stringBuilder가 target과 같다면 isSame을 true로 바꾸고 추후에 isSame의 조건문을 통해 dfs()함수를 멈춤
                isSame = true
                return
            }

            for (index in 0 until aeiouList.size) { //AEIOU List에 대해서 일일히 1개씩 다 추가한다.
                stringBuilder.append(aeiouList[index])
                if (isSame==true) { //만약 isSame의 신호를 받으면 dfs() 정지
                    return
                }
                if (depth+1<=5) { // depth+1이 5보다 작거나 같을때 까지만 반복하는데, 이유는 depth+1이 6이 되면 6글자인 상태라서 만족하는 5글자가 아니라서이다.
                    count++
                }
                dfs(depth+1,target) // depth+1 수행
                stringBuilder.deleteCharAt(stringBuilder.length-1) //dfs() 빠져나오면 stringBuilder 마지막 값 삭제
            }
        }
        dfs(0,word)
        println(count)
        answer = count


        /**
         * 방법 2. 규칙 이용 (참고 : https://bangu4.tistory.com/241)
         */
//        fun sol2(): Int{
//            val AEIOU_List = arrayListOf("A","E","I","O","U")
//
//            val digitList = intArrayOf(781,156,31,6,1)
//            var result = word.length
//
//            for (i in 0 until word.length) {
//                val index = AEIOU_List.indexOf(word[i].toString())
//                result +=digitList[i]*index
//            }
//            return result
//        }
//        answer = sol2()

        return answer
    }
}