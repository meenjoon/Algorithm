class Solution {
    var answer = 0
    var count = 0 //n 길이의 정사각형안에서 체스가 몇 개 놓여지는지 알아보려는 count

    fun solution(n: Int): Int {
        val array = IntArray(n)
        dfs(n,0,array)
        println(count)
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

        /** row가 0부터 시작하기 때문에 0부터 n-1을 두면 n개 만큼 다 둔 것이다.
         * 즉, row == n 개 만큼 놓았다는 것은 다 놓고 다음을 놓으려는 조건인데 이럴때는 return을 해주어 answer++ 해준다.
         * 쉽게 말해 마지막 행까지 다 놓았다면
         */
        if(row == n) {
//            println(count) //마지막 행까지 다 놓았다면 isPossible()함수를 통해 놓아진 퀸의 개수를 +1씩 더해준 것을 출력해준다.
            count = 0 //카운터를 0으로 초기화한다.
            answer++
            return
        }
        /** 0부터 n까지 반복한다.
         * i는 열의 값을 의미하기 때문에 array[row]에 i(열의 위치)에 퀸을 놓는다고 생각하면 편하다.
         * (row,i) ==> (x,y)
         */
        for(i in 0 until n) {
            array[row] = i //현재 행의 i(열의 위치)에 퀸을 놓는다.
            /**
             * 만약 isPossible() 함수에 현재 행에 퀸을 넣을 수 있는지 검사하여 넣을 수 있다면 다음 행으로 넘어가는 dfs(row+1,array)를 실행한다.
             */
            if(isPossible(row,array)) {
                count++ //isPossible()함수를 통해 true로 반환된 결과값(true)을 이용하여 true일때는 퀸을 놓는다는 것이니 이 경우 count의 개수를 +1씩해준다. 
                dfs(n,row+1,array)
            }
        }
    }
}