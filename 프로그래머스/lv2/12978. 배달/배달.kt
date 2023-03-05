

class Solution {
    /**
     * 1. 다익스트라 방법으로 풀기
     */
//    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
//        var answer = 0
//        val inf = 500001
//
//        /**
//         * 문제에서 1번마을 부터 출발한다.
//         * 하지만 배열은 0번부터 출발하기 때문에 미리 N+1의 사이즈 값을 주었다.
//         * (추후에 반복문의 인덱스를 사용할 때 1..N 을 사용하기 위함)
//         */
//        val map = Array(N+1) { IntArray(N+1)} //(출발지 -> 도착지) = map의 값
//
//        val visited = BooleanArray(N+1) //방문 했는지 체크 배열
//        val distance = IntArray(N+1) //간선 거리저장 배열
//
//        /**
//         * 최단 거리 구하는 방법
//         */
//        fun getMinimumIndex(): Int {
//            var minValue = inf
//            var minIndex = 0
//
//            for(index in 1..N){
//                /**
//                 * 방문하지 않았고 현재의 거리(distance[index]가 최소 값(minValue)보다 작다면 minValue와 minIndex 갱신한다.
//                 */
//                if(!visited[index] && distance[index] < minValue) {
//                    minValue = distance[index]
//                    minIndex = index
//                }
//            }
//            return minIndex
//        }
//
//        /**
//         * 본격적인 다익스트라 함수(하나의 지점(start)에만, 그 지점(start)의 최단 거리를 구해준다.)
//         */
//        fun dijkstra(start: Int) {
//
//            /**
//             * 거리 배열(distance배열)에 map의 값을 1부터 N번 마을까지의 간선 정보를 넣는다.
//             * map의 이중배열에는 간선의 정보가 저장되어 있는것을 이용을 하여,
//             * map[start][index] ==> map의 start지점(출발점)에서 index지점(도착점)까지의 정보를 distance 배열에 할당해준다.
//             */
//            for(index in 1 .. N) {
//                distance[index] = map[start][index]
//            }
//            /**
//             * 현재 구하려는 지점(start)은 방문을 하면 안되기에 미리 방문을 했다고 처리하기 위해
//             * 방문배열(visited배열) true로 바꿔준다.
//             */
//            visited[start] = true
//
//            /**
//             * 반복을 1부터 구하려는 마을 개수 -2 만큼 반복한다.(이건 공식처럼 외워야 할 듯)
//             */
//            for(index in 1 .. N-2) {
//                /**
//                 * minIndex를 위에서 만든 getMinimumIndex()를 이용해 최소 인덱스를 구한다.
//                 */
//                val minIndex = getMinimumIndex()
//                /**
//                 * 최소 인덱스를 방문했으니까 방문처리를 한다.
//                 */
//                visited[minIndex] = true
//
//                /**
//                 * 1부터 N마을 개수만큼 반복한다.
//                 */
//                for(index2 in 1..N) {
//                    /**
//                     * 만약 visited의 index2가 방문을 하지 않았다면, 그리고
//                     * 거리의 최소값 + map[minIndex][index2](minIndex에서 index까지의 간선 값)이 거리의 index2값보다 작다면 갱신한다.
//                     */
//                    if(!visited[index2]) {
//                        if(distance[minIndex] + map[minIndex][index2] < distance[index2]) {
//                            distance[index2] = distance[minIndex] + map[minIndex][index2]
//                        }
//                    }
//                }
//            }
//        }
//
//        /**
//         * map의 이중배열에 [1,1] [2,2] [3,3] 같은 부분을 제외하고 inf(500001)의 값으로 전부 초기화 시켜준다.
//         * [1,1] [2,2] [3,3] 같은 부분을 제외하는 이유는 1(출발지)에서 1(도착지)로 가는건 0의 값이기 때문이다.
//         */
//        for(i in 1..N) {
//            for(j in 1..N) {
//                if(i==j) {
//                    continue
//                }
//                map[i][j] = inf
//            }
//        }
//
//        /**
//         * Input값으로 주어진 road 이중배열의 값을 내가만든 inf로 전부 값을 초기화한 map 이중배열에 할당한다
//         * ==> 즉, road의 이중배열 대한 간선정보를 내가 만든 map 이중배열에 넣는다.
//         */
//        for(index in 0 until road.size) {
//            val a = road[index][0]
//            val b = road[index][1]
//            val w = road[index][2] //새로운 거리
////            road[index][0] + road[index][1] = 기존 거리
//            if(map[a][b] > w) {
//                map[a][b] = w
//                map[b][a] = w
//            }
//        }
//        /**
//         * 문제에서는 1번마을 이기때문에 dijkstra(1)을 해줌
//         */
//        dijkstra(1)
//
//        /**
//         * 다익스트라 함수 이기때문에
//         * 문제에서는 1번마을 이기때문에 dijkstra(1)을 해줬고, 그 결과에 대해서 distance배열(거리배열)에 1번마을에 대해서 다른 지점들에 대한 최단 거리가 나옴)
//         * ==> 그렇기에 현재 1번 마을을 기준으로 잡고 다른 마을들의 최단거리의 값이 distance배열에 들어 있는거다.
//         * 1번 마을로부터 다른 마을로까지 K 시간 이하로 배달을 해야하기 때문에,
//         * distance[index] 가 K보다 작거나 같아야 한다.
//         * ( distance[index]의 값은 1번 마을로부터 index마을과의 최단거리를 뜻함 )
//         */
//        for(index in 1..N) {
//            if(distance[index]<=k) {
//                answer++
//            }
//        }
//
//        return answer
//    }

    /**
     * 2. 플로이드 마셜 방법으로 풀기
     */
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0 //만족하는 마을 수
        val inf = 500001 //배달이 가능한 시간 최대
        /**
         * 문제에서 1번마을 부터 출발한다.
         * 하지만 배열은 0번부터 출발하기 때문에 미리 N+1의 사이즈 값을 주었다.
         * (추후에 반복문의 인덱스를 사용할 때 1..N 을 사용하기 위함)
         */
        val map = Array(N+1) { IntArray(N+1)} //(출발지 -> 도착지) = map의 값



        /**
         * map의 이중배열에 [1,1] [2,2] [3,3] 같은 부분을 제외하고 inf(500001)의 값으로 전부 초기화 시켜준다.
         * [1,1] [2,2] [3,3] 같은 부분을 제외하는 이유는 1(출발지)에서 1(도착지)로 가는건 0의 값이기 때문이다.
         */
        for(i in 1..N) {
            for(j in 1..N) {
                if(i==j){
                    continue
                }
                map[i][j] = inf
            }
        }


        /**
         * Input값으로 주어진 road 이중배열의 값을 내가만든 inf로 전부 값을 초기화한 map 이중배열에 할당한다
         * ==> 즉, road의 이중배열 대한 간선정보를 내가 만든 map 이중배열에 넣는다.
         */
        for(index in 0 until road.size) {
            val a = road[index][0]
            val b = road[index][1]
            val w = road[index][2] //새로운 거리
//            road[index][0] + road[index][1] = 기존 거리
            if(map[a][b] > w) {
                map[a][b] = w
                map[b][a] = w
            }
        }

        /**
         * 플로이드 마셜(정점과 정점 사이의 최소거리를 구해주는 알고리즘 적용 부분) 함수 시작
         */
        // 거쳐가는 노드
        for(k in 1..N) {
            //출발 노드
            for(i in 1..N) {
                //도착 노드
                for(j in 1..N) {
                    if(map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

        /**
         * 1번마을로부터 다른 마을까지의 최단 거리를 구하는데, K의 배달시간 이하만큼의 조건이 있으니,
         * map[1][index] ==> map의 1번마을에서부터 index마을까지의 최단 거리
         * k ==> 조건 배달시간
         * 따라서, 반복문 1번 마을부터 N마을까지
         * map[i][index] <= k 을 만족하는것은 배달할 수 있는 마을이다.
         * 즉, answer++를 해준다.
         */
        for(index in 1..N) {
            if(map[1][index]<=k) {
                answer++
            }
        }
        return answer
    }
}

// fun main(){
//     val ride1Instance = ride()
//     ride1Instance.solution(5, arrayOf(intArrayOf(1,2,1), intArrayOf(2,3,3,), intArrayOf(5,2,2), intArrayOf(1,4,2),
//         intArrayOf(5,3,1), intArrayOf(5,4,2)
//     ),3)
// }