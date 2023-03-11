class Solution {
    fun solution(s: String): Int {
        var answer = 0

        var minValue = s.length

        /**
         * chunked(자를갯수) 를 사용하게 된다면 범위를 넘어가는 indexOfException 오류를 발생시키지 않고, 마지막 까지 자를 수 있다.
         * 이 문제는 반복되는것을 이용하여 최소 길이로 압축을 해야하는 것이기 때문에 s의 길이의 반보다 넘어가면 반복되지 않기 때문에 1부터 s 길이의 반을 포함하여 반복하여야 한다.
         * 1부터 시작하는 이유는 chunked(자를갯수) 함수에 자를갯수를 넣어야하는데 0부터 시작하면 아무것도 안자르기 때문이다.
         */
        for (index in 1..s.length/2){
            val chunks = s.chunked(index)

            var chunkLength = 0

            var currentChunk = ""
            var overlapCount = 1
            /**
             * 그리고 i 갯수만큼 chunked()를 이용하여 자른 것을 chunks라는 변수에 넣고 이것을 이용하여,
             * 해당하는 갯수를 통해 압축하는 길이를 구하여 그 길이가 가장 짧은것을 구하면 되는것이다.
             * 해당하는 갯수를 자른것에 대해 각각 currentChunk(현재 원소), overlapCount(중복되는 횟수), chunkLength(압축한 후의 길이)를 할당한다.
             * currentChunk 변수의 초기값은 ""로 할당하는 이유는 chunks의 List 변수가 첫번째 인덱스 경우 같지 않다고 하기 위해서이다.
             * overlapCount 변수의 초기값을 1로 한 이유는 아무것도 중복된 것이 없을때 경우를 1로 잡아둔 거 뿐이다.
             */
            for((index,value) in chunks.withIndex()) {
                /**
                 * 뒤에 있는 currentChunk=value를 통해 currentChunk 전에 있는 값을 저장하게 되는데,
                 * 1. 이것과 현재의 value와 비교해서 같다면, 
                 * overlapCount를 +1을 해주고 그냥 넘어간다.
                 * 2. 만약 같지 않다면
                 * 2-1. overlapCount의 값의 크기부터 측정을 해서 1보다 크다면 즉, 중복이 존재하였다면,
                 * chunkLengh의 변수에 지금 중복된 값(숫자)을 String형태로 바꾸어 이것을 길이를 더해준다. 
                 * 그 후, overlapCount의 변수를 1로 다시 초기화 시켜준다. 왜냐하면 다음 인덱스의 값이 돌 때는 중복이 되지 않음을 선언해준것이다.
                 * 3. 그 후 chunkLength의 길이를 현재 value의 길이만큼 더해준다.
                 * 4. 전의 currentChunk를 현재 값인 value로 바꿔준다.
                 * 5. 현재 for문을 빠져나가 overlapCount가 1보다 크다면 chunkLength에 chunkLengh의 변수에 지금 중복된 값(숫자)을 String형태로 바꾸어 이것을 길이를 더해준다.
                 * ==> for문을 빠져나가서 중복 처리를 다시 한 이유는 만약에 chunks의 마지막 데이터의 값과 전의 데이터의 값이 같다면, continue 되기 때문에 그냥 for문을 빠져나와 중복된 값의 처리(중복된 숫자의 String길이 더하기)를 하지 못하기 때문이다.
                 * 6. 지역변수로 선언해논 minValue의 값과 비교해서 현재의 chunkLength의 값과 비교해서 더 작은 값은 다시 minValue에 초기화시킨다.
                 */
                if (currentChunk == value) {
                  overlapCount++
                  continue
                }
                if (overlapCount>1) {
                    chunkLength += overlapCount.toString().length
                    overlapCount = 1
                }
                chunkLength += value.length
                currentChunk = value
            }
            if (overlapCount>1) {
                chunkLength += overlapCount.toString().length
            }
            minValue = Math.min(minValue,chunkLength)
        }
//        println(minValue)

        return minValue
    }
}