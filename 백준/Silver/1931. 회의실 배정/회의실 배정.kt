import java.io.BufferedReader
import java.io.InputStreamReader

data class Conference(val start: Int, val end: Int): Comparable<Conference> {
    override fun compareTo(other: Conference): Int {
        return if (this.end == other.end)
            this.start - other.end
        else
            this.end - other.end
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val seq: MutableList<Conference> = mutableListOf()

    repeat(n) {
        val (start: Int, end: Int) = readLine()
            .split(" ")
            .map { it.toInt() }

        seq.add(Conference(start, end))
    }

    seq.sort()

    var count = 1
    var endTime = seq[0].end

    for (i in 1 until n) {
        if (seq[i].start >= endTime) {
            endTime = seq[i].end
            count++
        }
    }
    println(count)
}