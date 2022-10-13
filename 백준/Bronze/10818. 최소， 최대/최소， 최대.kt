import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var nn = StringTokenizer(br.readLine())
    var n = nn.nextToken().toInt()

    var st = StringTokenizer(br.readLine())

    var array = IntArray(n)


    var max = 0
    var min = 0


    for((index, temp) in (1..n).withIndex()) {

        array[index] = st.nextToken().toInt()
    }
    max = array.maxOrNull()!!
    min = array.minOrNull()!!

    bw.write("$min $max")
    bw.flush()
    bw.close()

}