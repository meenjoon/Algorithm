import java.io.*
import java.util.*

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var st2 = StringTokenizer(br.readLine())
    
    var n = st.nextToken().toInt()
    var a = st2.nextToken()

    var total = 0

    for (temp in 0..n-1){
        total += a[temp].toString().toInt()
    }

    bw.write("$total")
    bw.flush()
    bw.close()
}