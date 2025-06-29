import java.io.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))


    val n = br.readLine()!!.toInt()
    val array = Array(n) { "" }

    repeat(n) {
        val book = br.readLine()!!.toString()
        array[it] = book
    }

    array.sort()

    var maxTitle = array[0]
    var maxCount = 1
    var currentCount = 1
    for(i in 1 until n) {
        if(array[i] != array[i - 1]) {
            currentCount = 0
        }
        currentCount++
        if (currentCount > maxCount || (currentCount == maxCount && array[i] < maxTitle)) {
            maxTitle = array[i]
            maxCount = currentCount
        }
    }

    bw.write(maxTitle)

    bw.flush()
    bw.close()
}