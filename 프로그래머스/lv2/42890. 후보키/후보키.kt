class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        var answer = 0

        val column = relation[0].size //열
        val row = relation.size //행(데이터 개수)

        val visited = BooleanArray(column) //열의 개수만큼의 조합(순서 상관없음)이 필요하기 때문에

        val list = mutableSetOf<String>() //데이터의 인덱스 위치를 담는 중복이 불가능한 set

        val minimumList = mutableSetOf<String>() //최소성,유일성을 만족하는 set

        /**
         * 1개부터 열의 개수만큼의 조합을 만들어주는 combination 함수
         * 만약 열이 4개라면 for문을 통해 1부터 4까지 반복하면 pick(뽑는개수)가 0 이 되면 종료하게끔 만듦
         */
        fun combination(start: Int, pick: Int) {
            if(pick == 0) {
                var temp = ""
                for(index in 0 until column) {
                    if(visited[index]==true) {
                        temp += index
                    }
                }
                list.add(temp)
            }
            for(index in 0 until column) {
                if(!visited[index]) {
                    visited[index] = true
                    combination(start + 1, pick-1)
                    visited[index] = false
                }
            }
        }

        /**
         * 먼저 유일성의 조건을 만족하고,
         * 유일성의 조건을 만족하는 것 중에 최소성을 만족하는 것을 minimumList에 넣는다.

         * 유일성의 조건을 만족하는 로직은 list의 원소로부터 위치의 값을 받아오는데 이 값을 통해 relation 배열에 접근을 해서 데이터를 set에 넣는다.
         * set에 넣는데 set의 사이즈가 relation.size와 같다면 즉, relation 배열의 row값(데이터의 개수)가 만족하면 중복되는 것이 없다는 말이니까 유일성을 만족하게 된다.

         * 그 후 최소성을 만족하는 로직은 유일성을 만족하는 로직 중에서 list의 원소의 원소(한 개)이랑 minimumList의 원소의 원소(전부)이랑 하나씩 비교해서 만약 포함한다면 count라는 변수를 +1 해준다.
         * 만약 이 count 변수가 minimumList의 원소의 길이와 같다면 최소성을 만족하지 않음으로 isFlag라는 변수를 false로 바꾼다.
         * 그 후 isFlag라는 변수가 true이면, 즉, count 변수가 minimumList의 원소의 길이와 같지 않아서 변수 초기값 false 그대로라면 유일성,최소성을 만족하는 minimumList에 list의 원소값을 넣는다.
         */
        fun uniqueKey(relation: Array<Array<String>>) {
            for((listIndex, listValue) in list.withIndex()) {
                val set = mutableSetOf<String>()

                for(rowIndex in 0 until row) {
                    var temp = ""
                    for((divideListIndex, divideListValue) in listValue.withIndex()) {
                        temp+=relation[rowIndex][divideListValue-'0']
                    }
                    set.add(temp)
                }
//                println(set) //set에 데이터 제대로 들어갔나 확인

                if(set.size == row) {
                    var isFlag = true

                    for((minimumIndex, minimumValue) in minimumList.withIndex()) {
                        var count = 0
//                        println(minimumValue) //minimumList의 원소(String의 값) 출력
                        for((divideMinimumIndex, divideMinimumValue) in minimumValue.withIndex()) {
                            if(listValue.contains(divideMinimumValue)) {
                                count++
                            }
                        }
                        if(count==minimumValue.length) {
                            isFlag = false
                        }
                    }
                    if(isFlag) {
                        minimumList.add(listValue)
                    }
                }
            }

        }


        for(index in 1 .. column) {
            combination(0,index)
            uniqueKey(relation)
//            println(list)
            list.clear()
        }
        answer = minimumList.size
        println(answer)
        return answer
    }
}