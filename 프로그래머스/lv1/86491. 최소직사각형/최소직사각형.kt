class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var maxx = mutableListOf<Int>()
        var minn = mutableListOf<Int>()

        for(temp in sizes){
            if(temp[0]>temp[1]) {
                maxx.add(temp[0])
                minn.add(temp[1])
            }
            else{
                maxx.add(temp[1])
                minn.add(temp[0])
            }
        }
        answer = maxx.maxOrNull()!! * minn.maxOrNull()!!
        return answer
    }
}