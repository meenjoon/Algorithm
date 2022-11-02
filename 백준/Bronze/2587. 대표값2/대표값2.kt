import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var list = mutableListOf<Int>()

    var sum = 0

    for(temp in 1..5) {
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        list.add(n)
    }
    sum = list.sumBy { it }
    list.sort()

    bw.write("${sum/5}\n${list[2]}")


    bw.flush()
    bw.close()

}