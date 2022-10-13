import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var st2 = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()

    var array = FloatArray(n)

    var max: Float = 0.0F
    var average: Float = 0.0F

    for((index, element) in (1..n).withIndex()){
        val aa = st2.nextToken().toInt()
        array[index] = aa.toFloat()
    }

    max = array.maxOrNull()!!

    for((index, element) in (1..n).withIndex()) {
        array[index] = array[index] / max * 100
    }
    average = array.sum() / n

    bw.write("$average")
    bw.flush()
    bw.close()
}