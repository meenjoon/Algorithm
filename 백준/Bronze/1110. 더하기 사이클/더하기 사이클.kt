import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()

    var a = 0
    var b = 0
    var c = n
    var temp = 0
    var cnt = 0


    while (true) {
        a = n / 10
        b = n % 10
        temp = (a + b) % 10
        n = b*10 + temp
        cnt++
        if(c==n) break
    }
    bw.write("$cnt")
    bw.flush()
    bw.close()
}