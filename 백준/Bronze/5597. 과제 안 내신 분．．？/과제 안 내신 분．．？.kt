import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val array = IntArray(30)

    repeat(28) {
        array[br.readLine()!!.toInt() - 1] += 1
    }
    array.forEachIndexed { index, value ->
        if (value != 1) {
            bw.write("${index + 1}\n")
        }
    }

    bw.flush()
    bw.close()
}