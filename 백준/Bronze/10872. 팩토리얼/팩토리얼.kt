import java.util.*

fun main(args: Array<String>) {
    val n = Scanner(System.`in`)
    print(factorial(n.nextInt()))
}

private fun factorial(n: Int): Int = when (n) {
    0 -> 1
    else -> n * factorial(n - 1)
}