import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()
    var i = 2

    while (i<=n){
         if (n % i == 0){
            bw.write("$i\n")
            n /= i
        }
        else {
            i++
         }
    }

    bw.flush()
    bw.close()

}
