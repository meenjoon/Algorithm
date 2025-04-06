import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m)= br.readLine()!!.trim().split(" ").map { it.toInt() }

    val array = IntArray(n)

    repeat(m) {
        val line = br.readLine()!!.trim().split(" ").map {
            it.toInt()
        }
        for(i in line[0]..line[1]) {
            array[i-1] = line[2]
        }
    }
    array.forEach {
        bw.write("$it ")
    }

    bw.flush()
    bw.close()
}