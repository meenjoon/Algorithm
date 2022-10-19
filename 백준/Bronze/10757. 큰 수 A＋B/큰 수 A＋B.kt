@file:Suppress("UNREACHABLE_CODE")

import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var a = st.nextToken().toBigInteger()
    var b = st.nextToken().toBigInteger()

    bw.write("${a+b}")
    bw.flush()
    bw.close()
}