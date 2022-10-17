import java.io.*
import java.util.*

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken()[0]

    bw.write("${n.toInt()}")
    bw.flush()
    bw.close()
}