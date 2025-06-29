import java.io.*
import java.util.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val enteredSet = TreeSet<String>()

    val n = br.readLine()!!.toInt()
    repeat(n) {
        val(name, status) = br.readLine()!!.trim().split(" ").let {
            Pair(first = it[0], second = it[1])
        }

        if (status == "enter") {
            enteredSet.add(name)
        } else {
            enteredSet.remove(name)
        }
    }

    val enterArray = enteredSet.toTypedArray()

    enterArray.forEachIndexed { index, s ->
        val reversIndex = enterArray.size - 1 - index

        bw.write("${enterArray[reversIndex]}\n")
    }

    bw.flush()
    bw.close()
}