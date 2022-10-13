import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var array = IntArray(10)

    for((index, element) in (1..10).withIndex()){
        var aa = StringTokenizer(br.readLine())
        var bb = aa.nextToken().toInt()
        array[index] = bb % 42
    }
    array = array.toSet().toIntArray()

    bw.write("${array.size}")
    bw.close()

}