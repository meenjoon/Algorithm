import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()

    var answer = (c - a) / (a - b)

    if ((c-a)%(a-b)==0){
       answer = answer + 1
    }
    else {
        answer = answer + 2
    }

    bw.write("$answer")
    bw.flush()
    bw.close()
}