import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var array = IntArray(9)


    for((index, element) in (1..9).withIndex()){
        var aa = StringTokenizer(br.readLine())
        array[index] = aa.nextToken().toInt()
    }
    var max = array.maxOrNull()
    var maxindex = array.indexOf(max!!)

    bw.write("$max\n${maxindex+1}") //배열의 인덱스는 0부터 시작하기 때문에
    bw.flush()
    bw.close()

}