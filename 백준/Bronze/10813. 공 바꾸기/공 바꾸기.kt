import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine()!!.trim().split(" ").map { it.toInt() }

    val array = IntArray(n) { it + 1}

    repeat(m) {
        val (a, b) = br.readLine()!!.trim().split(" ").map { it.toInt() }
        val tempA = array[a-1]
        array[a-1] = array[b-1]
        array[b-1] = tempA
    }

    bw.write(array.joinToString(separator = " "))
    bw.flush()
    bw.close()
}