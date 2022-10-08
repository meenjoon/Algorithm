class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var bb = win_nums.sorted()
        var aa = lottos.sorted().filter { it -> it>0 }

        var zeroCount = lottos.count { it == 0 }

        var count = 0

        var maxcount = 0
        var mincount = 0

        var max = 0
        var min = 0


        for(aaa in 0..win_nums.size-1) {
            for (temp in 0..lottos.size - zeroCount -1 ){
                if(bb[aaa] == aa[temp] ){
                    count++
//                    println("${bb[temp]} : ${aa[temp]}")
                }
            }
        }

        maxcount = zeroCount + count


        mincount = count


        when(maxcount) {
            6 -> max = 1
            5 -> max = 2
            4 -> max = 3
            3 -> max = 4
            2 -> max = 5
            1 -> max = 6
            0 -> max = 6
        }
        when(mincount){
            6 -> min = 1
            5 -> min = 2
            4 -> min = 3
            3 -> min = 4
            2 -> min = 5
            1 -> min = 6
            0 -> min = 6
        }


        if(zeroCount==6){
            max = 1
        }


        println("$maxcount , $mincount")
        println("$max , $min")
        answer = intArrayOf(max,min)
        return answer
    }
}
