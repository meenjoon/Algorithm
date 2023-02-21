class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1

        val visit = BooleanArray(dungeons.size)

        var count = 0

        fun dfs(k:Int, count:Int) {
            for(i in 0 until dungeons.size) {
                // println("//$k, //$count")
                if (!visit[i] && dungeons[i][0] <= k) {
                    visit[i] = true
                    dfs(k-dungeons[i][1], count+1)
                    visit[i] = false
                }
            }
            // println("$k, $count")
            answer = Math.max(count,answer)
        }
        dfs(k,count)

        return answer
    }
}