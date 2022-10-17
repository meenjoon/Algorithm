import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken()
    var a = st.nextToken()

    var nn = n.reversed()
    var aa = a.reversed()

    var answer = if(nn>aa) bw.write(nn) else bw.write(aa)

    bw.flush()
    bw.close()
}