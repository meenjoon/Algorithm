import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    val array = br.readLine()!!.trim().split(" ").map {
        it.toInt()
    }.toIntArray()

    val v = br.readLine()!!.toInt()

    val cnt = array.filter{
        it == v
    }.count()

    bw.write("$cnt")
    bw.flush()
    bw.close()
}