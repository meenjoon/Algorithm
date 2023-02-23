class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()

        val map = mutableMapOf<String,String>()

        val list = mutableListOf<String>()

        /* 첫번째 반복문
        1. map에 <id, name>을 넣는다.
        2. for문을 통해 최종 닉네임으로 저장이 될 것이다. 이것을 두번째 반복문을 통해 비교를 한다.
            * 주의할 점은 name이 공백이 아닐경우에 map을 업데이트 해줘야한다.(Leave의 경우에는 이름이 없는데, 마지막 인덱스의 행동이 Leave의 경우 최종적으로 그 아이디의 name은 없기 때문이다.
         */
        for((index,value) in record.withIndex()) {
            val recordSplit = value.split(" ")
            val action = recordSplit.get(0)
            val id = recordSplit.get(1)
            var name =""
            if(recordSplit.size==3) {
                name = recordSplit.get(2)
            }
            if(name != "") {
                map.put(id, name)
            }
        }

        /* 두번째 반복문
        1. 첫번째 for문을 통해최종 닉네임이 있으니 for문을 끝가지 돌고 조건문을 행동에 대해 만들고 그 결과값을 list에 담는다.
         */
        for((index,value) in record.withIndex()) {
            val recordSplit = value.split(" ")
            val action = recordSplit.get(0)
            val id = recordSplit.get(1)

            if(map.contains(id) ) {
//                println("${id} ${map.getValue(id)} / $name")

                if(action == "Enter") {
//                    println("${map.getValue(id)}님이 들어왔습니다.")
                    list.add("${map.getValue(id)}님이 들어왔습니다.")
                }
                else if(action=="Leave") {
//                    println("${map.getValue(id)}님이 나갔습니다.")
                    list.add("${map.getValue(id)}님이 나갔습니다.")
                }
            }
        }

        answer = list.toTypedArray()

        return answer
    }
}