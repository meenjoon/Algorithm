import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()
    var k = 2;
    var i = 1

    while(k<=n){
        k += 6*i++
    }
    
    bw.write("$i")
    bw.flush()
    bw.close()
}