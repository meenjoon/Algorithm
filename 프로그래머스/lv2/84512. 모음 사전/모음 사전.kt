class Solution {
    fun solution(word: String): Int {
        var answer = 0

        val aeiouList = arrayListOf<String>("A","E","I","O","U")

        val stringBuilder = StringBuilder()

        var count = 0

        var isStop = false

        fun dfs(depth: Int, target: String) {
            if(stringBuilder.length==6) { //만약 stringBuilder의 길이가 aeiou보다 클 경우
                return
            }

            if(stringBuilder.toString() == target) { //만약 stringBulder가 word와 같을 경우
                isStop = true //추후 DFS
                return
            }

            for((index,value) in aeiouList.withIndex()) {
                stringBuilder.append(value)

                if(isStop == true) {
                    return
                }
                if(depth <= 4) { //aeiou는 0부터 4 인덱스 까지 존재함
                    count++
                }
                dfs(depth+1, target)
                stringBuilder.deleteCharAt(stringBuilder.length-1)
            }
        }

        dfs(0,word)
        answer = count

        return answer
    }
}