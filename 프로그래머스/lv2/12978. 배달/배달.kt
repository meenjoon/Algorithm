class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0

        /** map의 배열은 N*N의 2차원 행열로 구성된다.
         * map배열의 0번째 인덱스는 출발지 , 1번째 인덱스는 도착지, 값은 간선 개수이다.
         * map[출발지,도착지] = 간선 값(배달 시간)
         */
        val map = Array(N){IntArray(N)}

        /**
         * 출발지==도착지가 같은 경우라면 넘어가고,
         * 그 외의 경우(출발지!=도착지)에는 500001을 할당한다.
         * 여기서 중요한점은 배달 가능한 시간이 500000 이기 때문에 기본값으로 500001을 전부 넣어준다.
         */
        for(i in 0 until map.size) {
            for(j in 0 until map[0].size){
                if(i==j) {
                    continue
                }
                map[i][j] = 500001
            }
        }
        /** 정점(출발점)과 정점(도착점)을 연결해주는 배열을 만들어주는 부분
         * road는 이차원 배열인데 이 값을 value로 한 개씩 꺼내본다.
         * 만약 map[value[0]-1][value[1]-1] < value[2] 작다면은 어떤 것을 의미하면,
         * map[출발지][도착지] = 배달 시간이라고 했고, value[2]는 이어지는(새로운) 배달 시간이라고 생각하자.
         * 즉, 기존의 배달 시간이 새로운 배달 시간보다 작다면 넘어간다.(최소값을 구하기 위해)
         * 그 반대로 기존의 배달 시간이 새로운 배달 시간보다 크다면,
         * 기존의 배달시간(map[value[0]-1][value[1]-1])에 새로운 배달시간 값을 넣는다.
         * -1을 해준 이유는 map 배열은 0부터 시작 문제는 1번부터 시작하기 때문이다.
         */
        for(value in road) {

            if (map[value[0]-1][value[1]-1] < value[2]) {
                continue
            }
            map[value[0]-1][value[1]-1] = value[2]
            map[value[1]-1][value[0]-1] = value[2]
        }

        /**
         * 플로이드 와샬 : 정점과 정점 사이의 최소거리를 구해주는 알고리즘 적용 부분
         */
        // k = 거쳐가는 노드
        for (k in 0 until N ) {
            // i = 출발 노드
            for(i in 0 until N) {
                // j = 도착 노드
                for(j in 0 until N) {
                    if(map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

        /**
         * 1번 마을부터 출발하기 때문에 map[0]를 map[0][i]만큼 순환한다.
         * 이때 시간이 k이하이면 answer++
         * map[0]이라는 뜻은 배열이기때문에 0이고 문제에서 적용하면 1번 마을이 된다.
         * 즉 1번 마을(출발점)에서 도착점(i)의 값이 k보다 작다면 이라는 말이다.
         */
        for(index in 0 until N) {
            if(map[0][index]<=k){
                answer++
            }
        }
        return answer
    }
}