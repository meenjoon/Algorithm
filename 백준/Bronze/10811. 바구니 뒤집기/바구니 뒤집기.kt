import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine()!!.trim().split(" ").map { it.toInt() }

    /**
     * 배열의 반복문을 통해 정직하게 구현
     */
//    val array = IntArray(n) { it + 1 }
//
//    repeat(m) {
//        val (a, b) = br.readLine()!!.trim().split(" ").map { it.toInt() }
//
//        var start = a - 1
//        var end = b - 1
//
//        while(start < end) {
//            val temp = array[start]
//            array[start] = array[end]
//            array[end] = temp
//
//            start++
//            end--
//        }
//    }
//
//    bw.write(array.joinToString(" "))

    /**
     * List의 subList() 함수 활용 방법
     */
    val list = MutableList(n) { it + 1 }

    repeat(m) {
        val (a, b) = br.readLine()!!.trim().split(" ").map { it.toInt() }

        list.subList(a - 1, b).reverse()
    }

    bw.write(list.joinToString(" "))
    bw.flush()
    bw.close()
}
