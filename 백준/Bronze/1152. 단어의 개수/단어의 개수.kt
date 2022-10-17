import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    
    var answer = StringTokenizer(br.readLine()).countTokens()
    bw.write("$answer")
    bw.flush()
    bw.close()
}