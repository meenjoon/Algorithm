import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    val array = Array(n) { "" }
    repeat(n) { it ->
        val word = br.readLine()!!.toString()
        array[it] = word
    }

    array
        .distinct()
        .sortedWith { a, b ->
            if (a.length == b.length) {
                a.compareTo(b)
            } else {
                a.length - b.length
            }
        }.forEach {
            bw.write("$it\n")
        }

    bw.flush()
    bw.close()
}