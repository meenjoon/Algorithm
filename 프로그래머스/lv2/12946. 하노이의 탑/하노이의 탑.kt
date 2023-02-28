class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer = arrayOf<IntArray>()

        val list = mutableListOf<IntArray>()

        /** number의 개수의 원판이 있고 first 기둥에서 end 기둥으로 옮기는 함수이고, second 기둥은 보조로 사용할 기둥이다.
         * 자리는 고정된다고 생각하는게 중요하다.
         * 즉, 무조건 first 자리는 출발점, end 자리는 목적지 라는 자리는 분명하다. 그리고 나머지 second는 그 외의 것이라고 생각한다.
         */
        fun hanoi(number: Int, first:Int, second:Int, end:Int ) {
            if(number==0) {
                return
            }
            //맨 아래에 있는 원반을 제외한 모든 원반을 보조 기둥으로 옮기라는 뜻
            hanoi(number-1,first,end,second) //처음 출발지 지점을 first로 설정, 목적지 지점을 second로 설정한다.
//            println("$first $end")
            list.add(intArrayOf(first,end))
            hanoi(number-1,second,first,end) //처음 출발지를 전의 재귀함수에서의 목적지 였던 second로 잡고, 목적지 지점을 end로 한다.
        }
        hanoi(n,1,2,3)
//        list.forEach { it.forEach { print(it) } }
        return list.toTypedArray()
    }
}