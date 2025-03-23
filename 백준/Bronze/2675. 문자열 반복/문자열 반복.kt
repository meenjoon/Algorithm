import java.util.*
import kotlin.math.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextLine().toInt()

    repeat(n) {
        val (a, b) = sc.nextLine().split(" ").let {
            Pair(first = it[0].toInt(), second = it[1])
        }

        b.forEach {
            print(it.toString().repeat(a))
        }
        println()
    }
}