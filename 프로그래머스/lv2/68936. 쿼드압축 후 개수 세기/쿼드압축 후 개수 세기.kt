class Solution {
    
    var answer: IntArray = IntArray(2)

    /**
     * 모든 수가 같은 값인지 확인하기 위한 check 함수
     * 모든 수가 같은 값이라면 True, 다른값이 하나라도 있다면 false 리턴
     */
    fun check(x: Int, y: Int, size: Int, arr: Array<IntArray>): Boolean {
        for(i in x until x + size) {
            for(j in y until y + size) {
                if(arr[x][y] != arr[i][j]) {
                    return false
                }
            }
        }
        return true
    }

    /**
     * 분할정복을 수행하는 함수 dp
     * 시작지점의 x,y값과 재귀를 실행하는데 필요한 size(추후 2를 나누어 반으로 쪼개서 사용함), 배열 arr을 매개변수로 받는다.
     * 위에서 정의한 check 함수를 통해 모든 수가 같은지 확인하고, 만약 모두 같은 값이라면 answer 배열에서 해당하는 index(0 또는 1)값을 증가시킨디ㅏ.
     * 또한 4등분으로 구분된 영역에 재귀함수를 이용하여 호출한다.
     */
    fun dp(startX: Int, startY: Int, size: Int, arr: Array<IntArray>) {
        if(check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++
            return
        }
        dp(startX, startY, size/2, arr) // 1사분면
        dp(startX + size / 2, startY, size/2,arr) // 2사분면
        dp(startX,startY + size /2, size/2, arr) // 3사분면
        dp(startX+size/2, startY+size/2, size/2, arr) // 4사분면
    }

    fun solution(arr: Array<IntArray>): IntArray {
        dp(0,0,arr.size,arr)
        answer.forEach { print(it) }
        return answer
    }
}