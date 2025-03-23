import java.util.*
import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    while (true) {
        val line = br.readLine() ?: break

        bw.write("$line\n")
    }

    bw.flush()
    bw.close()
}