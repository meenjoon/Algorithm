import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val array = IntArray(9)
    repeat(9) {
        array[it] = br.readLine()!!.toInt()
    }

    val maxNum = array.maxOrNull()
    val maxNumIndex = array.indexOf(maxNum ?: 0)

    bw.write("$maxNum\n${maxNumIndex + 1}")
    bw.flush()
    bw.close()
}