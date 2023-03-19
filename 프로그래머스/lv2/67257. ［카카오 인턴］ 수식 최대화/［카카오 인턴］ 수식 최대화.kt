class Solution {
    var answer: Long = 0

    val divideNumber = mutableListOf<Long>()
    val divideOperator = mutableListOf<Char>()

    fun solution(expression: String): Long {
        val operatorArray = arrayOf("+","-","*")
        val stringBuilder = StringBuilder()
        val visited = BooleanArray(operatorArray.size)

        /**
         * 주어진 input expression 숫자와 연산자로 나누는 로직
         */
        fun divideNumberAndOperator() {
            var number = ""
            for(index in 0 until expression.length) {
                if (expression[index].isDigit()) {
                    number += expression[index]
                } else {
                    divideNumber.add(number.toLong())
                    divideOperator.add(expression[index])
                    number = ""
                }
            }
            divideNumber.add(number.toLong())
        }
        divideNumberAndOperator()
        /**
         * 어떠한 연산자는 어떠한 계산을 하는지에 대한 로직
         */
        fun calculate(numA: Long, numB: Long, operator: Char): Long {
            if (operator == '+') {
                return numA + numB
            } else if(operator == '-') {
                return numA - numB
            } else {
                return numA * numB
            }
        }

        /**
         * 현재 input 값인 expression에 어떤 연산자 값이 있는지 검사하고 인자값으로 우선순위 연산자의 배열(priorityOperator 매개변수)을 통해 calculate() 함수를 이용해 계산하는 로직
         */
        fun hasOperatorAndCalculate(priorityOperator: List<Char>) {
            val tempDivideNumber = MutableList<Long>(divideNumber.size){divideNumber[it]}
            val tempDivideOperator = MutableList<Char>(divideOperator.size){divideOperator[it]}

            for(index in 0 until priorityOperator.size) {
                var j = 0
                while (j<tempDivideOperator.size) {
                    if (priorityOperator[index] == tempDivideOperator[j]) {
                        val result = calculate(tempDivideNumber.removeAt(j),tempDivideNumber.removeAt(j),tempDivideOperator.removeAt(j))
                        tempDivideNumber.add(j--,result)
                    }
                    j++
                }
            }
            answer = Math.max(answer,Math.abs(tempDivideNumber[0]))
        }

        /**
         * (+,-,*)의 순열(순서 상관있음)을 구한다.
         * 만약 count(현재의 개수)가 depth(뽑을 개수, 여기선 3개) 같다면
         * 현재의 순열 조합값인 stringBuilder의 값을 List로 바꿔 hasOperatorAndCalculate()함수의 인자로 넘겨준다.

             * hasOperatorAndCalculate()함수 : 현재 input 값인 expression에 어떤 연산자 값이 있는지 검사하고 인자값으로 우선순위 연산자의 배열(priorityOperator 매개변수)을 통해 calculate() 함수를 이용해 계산하는 로직
         */
        fun dfs(count: Int, depth: Int, beginWith: Int) {
            if(count == depth) {
                val stringToList = stringBuilder.toList()
                hasOperatorAndCalculate(stringToList)
            }
            for(index in beginWith until operatorArray.size) {
                if(!visited[index]) {
                    visited[index] = true
                    stringBuilder.append(operatorArray[index])
                    dfs(count+1, depth, beginWith)
                    visited[index] = false
                    stringBuilder.deleteCharAt(stringBuilder.length-1)
                }
            }
        }
        dfs(0,operatorArray.size,0)

        return answer
    }
}