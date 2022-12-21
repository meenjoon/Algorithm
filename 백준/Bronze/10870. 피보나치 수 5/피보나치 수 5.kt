import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    fun fib (a : Int): Int {
        if(a == 0) {
            return 0
        }
        if(a == 1) {
            return 1
        }
        return fib(a-2) + fib(a-1)

    }
    bw.write("${fib(n)}")
    bw.flush()
    bw.close()
}
