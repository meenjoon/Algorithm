import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object Main {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val aSet = HashSet<Int>()
        st = StringTokenizer(br.readLine())
        //for문의 조건에는 주로 범위 연산자인 in을 사용합니다.
        //ex) for (i in 1 until 10) { ... } -> 1부터 9까지 1씩 증가(10은 미포함)
        for (i in 0 until a) {
            aSet.add(st.nextToken().toInt())
        }
        st = StringTokenizer(br.readLine())
        for (i in 0 until b) {
            val num = st.nextToken().toInt()
            if (aSet.contains(num)) {
                aSet.remove(num)
            } else {
                aSet.add(num)
            }
        }
        println(aSet.size)
    }
}