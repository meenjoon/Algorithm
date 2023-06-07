import java.lang.StringBuilder

class Solution {
    fun solution(p: String): String {
        /**
        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        4-3. ')'를 다시 붙입니다.
        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        4-5. 생성된 문자열을 반환합니다.
         */
        var answer = ""

        if(p=="") {
            return ""
        }
        var balanceNum = 0 // '('의 괄호와 ')'의 괄호 갯수가 합쳐서 0이 되면 균형적인 괄호이다.
        val stringBuilder = StringBuilder()
        var balanceIndex = 0 // balanceNum이 0이 될때의 인덱스 값을 넣는다.즉, 균형적인 괄호의 마지막 인덱스 값을 넣는다.

        for(index in 0 until p.length) {
            if(p[index]=='(') {
                balanceNum += 1
            }
            else {
                balanceNum -=1
            }
            if(balanceNum == 0 ){
                balanceIndex = index
                break
            }
        }

        val u = p.substring(0..balanceIndex) //균형적인 괄호를 담는 u 변수
        val v = p.substring(balanceIndex+1 .. p.length-1) //균형적인 괄호 다음부터 끝까지를 담는 v 변수

        if (u[0] == '(') { // 균형적인 괄호 변수 u의 첫번째 시작이 '(' 일때, 즉 올바른 괄호 문자열 일 때
            stringBuilder.append(u) //올바른 괄호열이기 때문에 u를 전부 담는다.
            stringBuilder.append(solution(v)) // 그리고 다시 v(균형적인 괄호 다음부터 끝까지)를 solution 함수에 추가한 값을 stringBuilder에 넣는다.
        }
        else {  // 균형적인 괄호 변수 u의 첫번째 시작이 '('가 아닐때, 즉 올바른 괄호 문자열 이지 않을때
            stringBuilder.append('(')
            stringBuilder.append(solution(v))
            stringBuilder.append(')')

            u.substring(1..u.length-2).forEach {
                stringBuilder.append(
                    if(it == '(') {
                        ')'
                    }
                    else {
                        '('
                    }
                )
            }
        }
        return stringBuilder.toString()
    }
}