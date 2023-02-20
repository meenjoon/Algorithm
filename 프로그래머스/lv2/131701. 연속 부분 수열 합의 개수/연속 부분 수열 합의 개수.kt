class Solution {
    fun solution(elements: IntArray): Int {
        
        var answer: Int = 0

        //중복이 없는 합을 위해 set 컬렉션을 이요한다.
        val set = mutableSetOf<Int>()

        //연속된 수열을 만들기 용이하기 위해 주어진 배열의 2배 사이즈가 되는 새로운 배열을 만든다. 또한 초기값은 그냥 0으로 할당시켜준다.(이유 없긴 함)
        val array = IntArray(elements.size * 2) { 0 }

        //수열의 2배 사이즈인 array 수열에 IntArray 타입인 elements의 2배 크기로 array의 값에 할당시켜준다.
        for(index in 0 until array.size) {
            array[index] = elements[index % elements.size]
        }

//        array.forEach { print(it) }

        //첫번째 for문은 0부터 elements.size-1 만큼 반복한다.
        for (i in 1 until elements.size+1) {
            //두번째 for문은 0부터 elements.size 만큼 반복한다. 이유는 elements.size 인덱스 값에 있는 데이터는 배열 시작값인데 이것을 포함시키기 위해서이다.
            //array.copyOfRange(x,y)의 함수는 x인덱스의 값부터 y인덱스의 값을 잘라내는 함수다.
            for(j in 0 until elements.size) {
                set.add(array.copyOfRange(j,j+i).sum())
            }
        }
//        println(set)
        answer = set.size
        return answer
    }
}