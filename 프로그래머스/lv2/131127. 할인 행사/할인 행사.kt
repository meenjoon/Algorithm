class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val map = mutableMapOf<String,Int>()

        val tenCutList = mutableListOf<String>()

        /*
        먼저 map을 이용하여 <원하는 제품, 원하는 수량>을 저장한다.
         */
        for(index in 0 until want.size) {
            map.put(want[index],number[index])
        }
//        println(map)


        /*
        map의 value를 통해 정렬을 해야하므로 List로 바꾼후 정렬후 다시 Map으로 바꾼다.
         */
        val sortMap = map.toList().sortedBy { it.second }.toMap()
//        println(sortMap)


        /** 
         * 아래는 dicount배열에서 index가 +1 씩 변경함에 따라 
         * 10개의 배열만큼 자를 수 있을때 까지 자를 수 있는 로직이다.
         * 그 결과로 tenCutList에 10개의 값이 들어가게 된다.
         */
        //우선 할인하는 제품을 나타내는 문자열 사이즈 만큼 반복을 한다.
        for(index in 0 until discount.size) {
            // 만약 index가 dicount.size-10보다 작은 경우에(이유는 index는 +1 씩 증가하고 그에 따라 10일도 더해줘야하는데 index+10을 했는데 discount의 사이즈를 벗어나면 ArrayIndexOutOfBoundsException 발생한다.
            // 또한 discount.size-10을 만족하지 않는 else의 경우 break를 통해 종료해준다. 이유없이 계속 for문 돌면 runtime 낭비
            if (index<=discount.size-10) {
                //index부터 index+9 까지 반복하는데 discount에 그 index를 넣고 tenCutList(10개로 자른 list)에 그 값들을 추가시켜준다.
                for (index2 in index..index + 9){
                    tenCutList.add(discount[index2])
                }
//                list.forEach { print(it) }
//                println()
//                println(list.size)

                /*
                satisfiedCount 변수는 count 변수가 0이 되면 값을 ++ 한다.
                이때 각각 원하는 제품과 수량에 대해서 count를 0으로 만족해야지만 satisfiedCount 변수가 ++ 되고 그렇게 쌓인 satisfiedCount 변수와 wantSize와 같아지면(각각의 원하는 제품과 수량을 구매 할 수 있다면) 최종값 answer을 ++해준다.
                 */
                var satisfiedCount = 0 // 각각의 원하는 제품과 수량을 모두 구매 가능한 것을 밑에 있는 count 변수로 비교를 해주는데 이때 count가 0이 될 경우 satisfiedCount 변수를 ++ 시키고 추후에 wantSize(원하는 제품 문자열 크기)와 비교해서 같으면 최종 결과값(answer)을 ++ 해준다.
                val wantSize = want.size //원하는 제품 문자열의 크기

                /** 아래에서는 다음과 같은 로직이다.
                 * 원하는 제품 배열( 바나나,사과,딸기), 원하는 제품의 수량(1,2,3) 이 있다고 했을때,
                 * 위에서 자른 tenCutList안에서 tenCutList안에 들어있는 요소와 // 원하는 제품과 수량이 들어있는 sortedMap의 제품(value)과 비교해서 같은 것이 수량(key)만큼 있으면 satisfiedCount를 증가시키는것이다.
                 * 그 후 satisfiedCount 가 원하는 제품 배열의 크기 사이즈와 동일하면 제품을 전부 살 수 있는것이라고 생각 할 수 있다.
                 */
                
                
                /**
                 * 주의 할 점은 아래의 for문은 tenCutList와 sortMap<원하는 제품,원하는 수량>과 비교하는 것이다.
                 * tenCutList는 위에서 말햇듯이 index <= discount.size-10 까지만 생성된다.
                 */
                for(mapValue in sortMap) { // sortMap은 고정값이고 변하지 않는다. sortMap을 반복문을 이용해 각각의 index의 (key,value)에 접근한다.
                    var count = mapValue.value 
                    //count 변수는 현재 sortMap의 (key,value) 중의 value의 값으로 할당했다. 왜냐하면 value의 의미는 원하는 제품의 수량이기 때문이다. 
                    // 그렇기에 아래의 for문을 통해 key(원하는 제품 이름)과 tenCutList를 비교해주게 되면 만약 tenCutList안의 값 중에 key(원하는 제품 이름)과 동일하면 count를 --해주고 결국 0이되면 원하는 제품의 수량을 구매할 수 있다는 말이다.

                    for(index3 in 0 until tenCutList.size) {
                        if(mapValue.key == tenCutList[index3]) {
                            count--
                        }
                    }
                    
                    /** 만약 현재 index의 sortMap의 (key, value)에서 value(수량)이 tenCutList와 비교해서 0이 되면 즉, tenCutList안에서 원하는 제품(key)를 value(수량)만큼 구매가 가능하면 ==> 즉, count == 0 이라면
                        제품을 나타내는 문자열 배열 크기만큼 제품을 살 수 있는지를 체크해주는 satisfiedCount 변수를 ++ 해준다
                        그러면 당연히 추후에 satisfiedCount == wnat.size가 되면 각각의 제품을 수량만큼 전부 살 수 있는것을 알 수 있겠지?
                        그래서 아래는 satisfiedCount == wnat.size를 비교한다.
                     */

                    /**
                     * 아래의 조건문은 현재 인덱스의 제품을 수량 껏 살 수 있다면 다음 제품을 비교
                     */
                    if(count == 0) { 
                        satisfiedCount++
                        continue
                    }
                    /** 현재 인덱스의 제품을 수량 껏 사지 못한다면 tenCutList와 sortMap<원하는 제품,원하는 수량>을 비교하는 for문을 빠져 나온다.
                     * 
                     */
                    else{ 
                        tenCutList.clear()
                        break
                    }
                }
                /**  
                 * satisfiedCount가 wantSize(원하는제품배열크기)가 되면 각각의 제품에 대해서 원하는 수량만큼 살 수 있다는 말이니까
                 * answer를 ++해준다.
                 * 그 후 당연히 tenCutList를 빈 값으로 초기화시켜준다.
                 */
                if(satisfiedCount==wantSize) {
                    tenCutList.clear()
//                    println("//$index")
                    answer++
                }
            }
            else {
                break
            }

        }
        return answer
    }
}