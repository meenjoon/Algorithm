import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val str = sc.next()
        val array = arrayOfNulls<String>(str.length)
        //for문의 조건에는 주로 범위 연산자인 in을 사용합니다.
        //indices는 컬렉션 타입의 인덱스값을 의미하므로 여기서는 for 문을 반복하면서 0, ... , array 길이 값을 i에 대입합니다.
        for (i in array.indices) {
            array[i] = str[i].toString()
        }
        Arrays.sort(array, Collections.reverseOrder())
        //ex) for (i in 1 until 10) { ... } -> 1부터 9까지 1씩 증가(10은 미포함)
        for (i in 1 until array.size) {
            array[0] += array[i]
        }
        println(array[0])
        sc.close()
    }
}