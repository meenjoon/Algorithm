import java.util.Stack

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        var stack = Stack<Int>()

        for(m in moves) {
            for(i in board.indices){
                if(board[i][m-1] != 0) {
                    if(stack.isNotEmpty() && stack.peek() == board[i][m-1]) {
                        stack.pop()
                        answer += 2
                    }
                    else {
                        stack.push(board[i][m - 1])
                    }
                    board[i][m-1]= 0
                    break
                }
            }
        }

        return answer
    }
}