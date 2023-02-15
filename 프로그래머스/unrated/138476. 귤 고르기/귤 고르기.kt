class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {

        var answer: Int = 0

        var current_Value = k //원하는 개수 
        var before_Value = 0 //전의 값을 넣어주기 위한 용도의 변수

        var itemCount = 0 // 현재의 값과 before_Value와 비교해서 같으면 같은 수 이기에 itemCount를 ++해주지 않고 다르면 다른 수 이기에 itemCount를 ++ 한다.

        val map = mutableMapOf<Int,Int>() //각 수가 몇 개 있는지 map에 담기 위한 용도 <값,값의 개수>의 목적

        val list = mutableListOf<Int>() //tangerine을 각 원소 개수의 크기만큼 정렬을 한 값을 넣기 위한 List

        for(index in 0 until tangerine.size) { //<값,값의 개수> , key에 중복된 값이 들어가면 값의 개수 +1 해준다.
            map.put(tangerine[index],map.getOrDefault(tangerine[index],0)+1)
        }

        val map_Custom = map.toList().sortedByDescending { it.second }.toMap() //map의 value(값의 개수)로 정렬을 해주기 위한 용도

        /*
        값의 개수로 정렬된 map으로 부터 for문의 범위를 1부터 값의 개수까지 반복을 해주고 list에 key를 넣어준다. 이유는 key값(값)을 value값(값의개수) 개수만큼 반복해주기 위해서다.
        결과값으로, 값의 개수로 내림 차순 정렬된 list가 생성된다.
         */
        for(value in map_Custom) { 
            for(index in 1..value.value) {
                list.add(value.key)
            }
        }
        
//        list.forEach { print(it) }
//        println()

        for(index in 0 until list.size) {
            for(index2 in index until list.size) {

                current_Value = current_Value-1 //내가 뽑으려는 개수에서 -1을 해주는데, 이것을 반복하여 0이 나오면 멈춘다.
                if(before_Value!=list[index2]) {//before_Value는 이 전의 index2의 값인데, 이것이 동일하지 않을때만 itemCount를 ++해준다.
                    itemCount++
                }
                if(current_Value==0) { //내가 뽑으려는 개수가 0이 되면 itemCount를 return 해준다.
//                    println(itemCount)
                    return itemCount
                }

                before_Value = list[index2] // 현재 index2의 값을 before_Value에 넣어 초기화해준다. 이유는 다음 반복문에서 그 다음 반복문의 index2의 해당하는 값과 미리 저장된 전의 index2의 해당하는 값과 비교하기 위해서이다. 비교를 하는 이뉴는 값이 같으면 같은 수 이기 때문에 ItemCount를 ++해주면 안되기 때문이다.
            }
        }
        return itemCount
    }
}