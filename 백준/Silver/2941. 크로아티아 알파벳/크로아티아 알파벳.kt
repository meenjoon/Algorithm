import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken()

    var total = 0

    var a = n.split("c=","c-","dz=","d-","lj","nj","s=","z=").joinToString(" ")

    for(temp in a){
        total += 1
    }
    bw.write("$total")
    bw.flush()
    bw.close()
}