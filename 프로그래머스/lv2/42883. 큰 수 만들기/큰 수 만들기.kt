class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""

        var maxPointer = 0//큰 값의 위치를 저장하고, maxPointer+1를 하여 그 다음 인덱스부터 시작하도록 하게 하는 역할을 한다.

        val stringBuilder = StringBuilder()//해당 인덱스의 해당하는 범위의 Max값을 넣는다.

        
        for(i in 0 until number.length-k) { //0의 인덱스부터 number의 크기-k 만큼 반복을 한다.(우리가 필요한 개수는 전체 길이에서 k를 빼줘야하니까)
            var max = 0 // max는 인덱스가 바뀔때마다 새롭게 초기화되어야 한다.(유지가 된다면 max보다 큰 수가 없을 경우가 있다.)
            for(j in maxPointer .. i+k) { //전 범위의 max의 값 인덱스인 maxPointer부터 위의 for문의 i에 k를 더한곳까지 반복을 한다.(범위는 당연히 위에 for문 i+k만큼 정해져있다.)
                //주의할 점은 j의 끝나는 범위 i+k로 고정되어야 한다. 이 범위 안에서의 max를 찾는게 목표다.
                
                if(max<number[j]-'0') { //만약 max의 값이 현재 인덱스의 값보다 클 경우
                    // println("$i,$j ${number[j]}")
                    max = number[j]-'0'//맥스를 현재 인덱스의 값을 할당한다.
                    maxPointer = j+1 //maxPointer, 즉 max에 대한 위치(index)에 대한 값에 +1을 해주어 다음 for문에 이 maxPointer로부터 시작하게 한다.
                }
            }
            // println()
            stringBuilder.append(max)// 최종적으로 2번째 for문을 빠져나가면 해당하는 범위의 max의 값이 나오기 때문에 이 max를 stringBuilder에 넣는다.
        }
//        println(stringBuilder.toString())
        answer = stringBuilder.toString()
        return answer
    }
}