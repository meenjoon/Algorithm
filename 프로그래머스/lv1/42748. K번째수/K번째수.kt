class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        var aa = array
        var ss = 0


        for((index1, element1) in commands.withIndex()){
            for((index2, element2) in element1.withIndex()){
                aa.slice(commands[index1][index2]..commands[index1][index2+1])
                break
            }
        }

         

        println(aa)

        return answer
    }
}