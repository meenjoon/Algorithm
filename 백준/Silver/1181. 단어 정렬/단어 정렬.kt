import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    var list = mutableListOf<String>()

    for(temp in 1..n){
        val st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toString()

        list.add(a)
    }

    var set = list.toMutableSet().sortedWith(compareBy({it.length},{it}))

    for(temp in set){
        bw.write("$temp\n")
    }
    bw.flush()
    bw.close()

}