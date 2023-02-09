import java.util.Stack

class Solution {
    fun solution(s: String): Int {
        // s를 한칸씩 회전하면서 isTrue의 조건을 만족하는 개수를 반환
        return s.indices.count{ isTrue(s.substring(it, s.length) + s.substring(0, it)) }
    }

    fun isTrue(s:String):Boolean{
        val openBracket = charArrayOf('(', '{', '[')
        val closeBracket = charArrayOf(')', '}', ']')
        val stack = Stack<Char>()
        var flag = false
        // 만일 닫힌 괄호로 시작한다면 false반환
        for(c in closeBracket) if(c == s[0]) return false

        for(c in s){
            flag = false
            for(i in openBracket.indices)
                // 스텍이 비어있지 않고 직전에 넣은 스텍이 열린 괄호 이면서 닫는 괄호와 짝이 맞는 경우 flag를 true로 변경
                if(stack.isNotEmpty() && stack.peek() == openBracket[i] && c == closeBracket[i])
                    flag = true
            // flag가 true이면 stack pop
            if(flag) stack.pop()
            // flag가 false 이면 stack에 c추가
            else stack.add(c)
        }
        // 스택이 비어있으면 모두 올바른 괄호
        return stack.isEmpty()
    }
}