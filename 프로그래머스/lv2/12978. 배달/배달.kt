class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
            var answer = 0

            val map = Array(N){IntArray(N)}

            for(i in 0 until map.size) {
                for(j in 0 until map[0].size) {
                    if(i==j){
                        continue
                    }
                    map[i][j] = 500001
                }
            }

            for(data in road) {
                //map[data[0]-1]data[1]-1] ==> 기존의 다리
                // data[2] ==> 새로운 다리
                if(map[data[0]-1][data[1]-1] < data[2]) {
                    continue
                }
                map[data[0]-1][data[1]-1] = data[2]
                map[data[1]-1][data[0]-1] = data[2]
            }

            for(k in 0 until map.size) {
                for(i in 0 until map.size) {
                    for (j in 0 until map.size){
                        if(map[i][k] + map[k][j] < map[i][j]) {
                            map[i][j] = map[i][k] + map[k][j]
                        }
                    }
                }
            }

            for (i in 0 until map[0].size) {
                if(map[0][i]<=k) {
                    answer++
                }
            }

            return answer
        }
}