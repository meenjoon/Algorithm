class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        
        var priorities_IndexValue = priorities.withIndex().toMutableList()

        var count = 0

        while (priorities_IndexValue.isNotEmpty()) {
            val first_Value = priorities_IndexValue.first()
            priorities_IndexValue.removeAt(0)

            /*
            큰 수대로 차례대로 정렬을 먼저 해주는 것임, 만약 큰 수가 있다면 if문의 조건으로 인해 continue가 계속 진행되기 때문에 아래로 내려가지 못함.
             any{} 람다함수는 클로저에 정의된 함수가 참인 경우가 하나라도 존재하며 true를 반환하는 메소드이다.
             */
            if(priorities_IndexValue.any{first_Value.value<it.value}) {
                priorities_IndexValue.add(first_Value)
                continue
            }
            /*
            정렬이 완료가 되었으면 위의 if()문이 실행되지 않으며 아래의 if()이 실행되어 원하는 location을 찾는다.
            원하는 location의 수를 만족하지 못했다면 count를 ++해주고 다음 while 반복문으로 돌아간다.
             */
            count++
            if(first_Value.index==location) {
                break
            }

        }
        answer = count

        return answer
    }
}