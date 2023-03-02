class Solution {
    var answer = 0

    fun solution(n: Int): Int {
        val array = IntArray(n)
        dfs(n,0,array)
        return answer
    }

    fun isPossible(row: Int, array: IntArray): Boolean {
        for(i in 0 until row) {
            //row 는 현재 행의 번호를 말하고 array[row]의 값은 열이다.
            // i 는 이전 행들에 놓여진 퀸의 값을 저장한 것들은 for문을 통해 +1씩 해주어 검사한다고 생각하면 된다. (array[i]: 이전 행의 퀸의 열 위치)
            // 또한 row-i는 대각선이라는 것을 의미하면 절댓값 abs를 통해 array[row]값과 array[i]의 값을 빼서 같으면 같은 대각선이라는 것이다.
            if(array[i] == array[row] || Math.abs(row - i) == Math.abs(array[row]-array[i])) {
                return false
            }
        }
        return true
    }

    fun dfs(n: Int, row: Int, array: IntArray) {
        if(row == n) {
            answer++
            return
        }

        for(i in 0 until n) {
            array[row] = i
            if(isPossible(row,array)) {
                dfs(n,row+1,array)
            }
        }
    }
}