import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val x = nextInt()
    val y = nextInt()
    val w = nextInt()
    val h = nextInt()

    val list = mutableListOf<Int>()
    list.add(x - 0)
    list.add(y - 0)
    list.add(w - x)
    list.add(h - y)

    println(list.minByOrNull { it })
}