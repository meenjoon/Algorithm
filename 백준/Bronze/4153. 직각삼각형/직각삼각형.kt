import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val lengths = readLine().split(" ").map { it.toDouble() }.sorted()

        if (lengths.count { it == 0.0 } == 3) break

        if (lengths[0].pow(2) + lengths[1].pow(2) == lengths[2].pow(2)) println("right")
        else println("wrong")
    }
}