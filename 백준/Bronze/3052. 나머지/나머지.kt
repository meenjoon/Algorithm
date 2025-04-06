import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val array = BooleanArray(1000) { false }

    repeat(10) {
        val n = br.readLine()!!.toInt()

        array[n % 42] = true
    }

    bw.write("${array.count{ it }}")
    bw.flush()
    bw.close()
}