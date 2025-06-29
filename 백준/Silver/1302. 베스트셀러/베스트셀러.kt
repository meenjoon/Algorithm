import java.io.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val map: MutableMap<String, Int> = HashMap<String, Int>()

    val n = br.readLine()!!.toInt()
    repeat(n) {
        val name = br.readLine()!!.toString()

        map[name] = map.getOrDefault(name, 0) + 1
    }
    val maxCount = map.maxByOrNull { it.value }?.value

    val bestSellerBook = map.filter { it.value == maxCount }.keys.minOrNull()

    bw.write("$bestSellerBook")

    bw.flush()
    bw.close()
}