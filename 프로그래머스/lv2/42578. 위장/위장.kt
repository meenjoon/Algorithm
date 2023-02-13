class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 0
        val map = mutableMapOf<String, Int>()

        for(index in 0 until clothes.size) {
            for(index2 in 0 until clothes[index].size) {

                if(clothes[index].size-1 != index2) {
                    map.put(clothes[index][clothes[index].size-1],map.getOrDefault(clothes[index][clothes[index].size-1],0)+1)
                }
            }
        }

        // println(map)

        answer = map.values.fold(1) { total, num -> total * (num+1)} // 중요한건 초기값 1부터 시작해서 total의 값이 1인것이다. 그 후 계속 연산을 해서 그 결과값은 total의 값은 중첩된다.

        // println(answer)
        return answer -1
    }
}