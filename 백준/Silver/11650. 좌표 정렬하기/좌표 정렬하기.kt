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

    var array = Array(n) {IntArray(2)}

    for((index, element) in (1..n.toInt()).withIndex()){
        val st2 = StringTokenizer(br.readLine())
        val a = st2.nextToken().toInt()
        var b = st2.nextToken().toInt()
        array[index][0] = a
        array[index][1] = b
    }

   array.sortWith(compareBy({it.first()},{it.last()}))

    for((index, element) in (1..n.toInt()).withIndex()){
        bw.write("${array[index][0]} ${array[index][1]}\n")
    }

    bw.flush()
    bw.close()

}