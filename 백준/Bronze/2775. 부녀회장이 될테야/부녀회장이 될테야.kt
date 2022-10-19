import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var apart = Array(15) { IntArray(15) {0} }

    for(i in 0..14) {
        apart[0][i] = i
        apart[i][1] = 1
    }

    for(i in 1..14){
        for(j in 2..14){
            apart[i][j] = apart[i-1][j] + apart[i][j-1]
        }
    }
    for(temp in 1..n){
        var st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toInt()
        var st3 = StringTokenizer(br.readLine())
        var b = st3.nextToken().toInt()

        bw.write("${apart[a][b]}\n")
    }

    bw.flush()
    bw.close()
}