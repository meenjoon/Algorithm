import java.util.*
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        /**
         * Queue는 먼저 들어온게 먼저 나가는 선입선출 구조
         */
        // 다리를 건너는 트럭 Queue
        val ridingTruck = LinkedList<Int>()
        // 대기하는 트럭
        val watingTruck = LinkedList<Int>()


        // 다리 길이만큼 0을 채워준다.
        for(i in 0 until bridge_length ) {
            ridingTruck.add(0)
        }
        // 트럭의 무게배열을 대기하는 트럭 배열에 값을 할당한다.
        for(i in 0 until truck_weights.size) {
            watingTruck.add(truck_weights[i])
        }

        while(ridingTruck.isNotEmpty()) { //다리를 건너는 트럭이 비어있지 않을때까지 반복
            answer++ //시간 1초 추가
            ridingTruck.poll() //다리를 건너는 트럭의 앞의 데이터를 삭제 후 반환
            if(watingTruck.isNotEmpty()) { //대기하는 트럭이 비어있지 않는다면
                /**
                 * (제한 무게 - 대기 트럭의 첫번째 값)이 다리를 건너는 트럭 리스트의 전체 데이터 값보다 크다면
                 * 즉, 계속 적재할 수 있다면 다리를 건너는 트럭 리스트(bridgeQueue)가 또 트럭을 적재할 수 있다.
                 */
                if(ridingTruck.sum() <= weight - watingTruck.peek()) {
                    ridingTruck.add(watingTruck.poll())
                }
                // 만약 그렇지 않다면 그냥 다리를 건너는 트럭 리스트(bridgeQueue)에 0을 추가한다.
                else {
                    ridingTruck.add(0)
                }
//                println(ridingTruck)
            }
        }
        return answer
    }
}