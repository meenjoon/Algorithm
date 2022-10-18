import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    var answer = 0

    if(b>=c) {
        answer = -1
    }
    else {
        val n = a/(c-b)
        answer = n + 1
    }
    bw.write("$answer")
    bw.flush()
    bw.close()
}