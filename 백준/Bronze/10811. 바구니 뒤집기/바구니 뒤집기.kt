import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine()!!.trim().split(" ").map { it.toInt() }

    val array = IntArray(n) { it + 1 }

    repeat(m) {
        val (a, b) = br.readLine()!!.trim().split(" ").map { it.toInt() }

        var start = a - 1
        var end = b - 1

        while(start < end) {
            val temp = array[start]
            array[start] = array[end]
            array[end] = temp

            start++
            end--
        }
    }

    bw.write(array.joinToString(" "))
    bw.flush()
    bw.close()
}
