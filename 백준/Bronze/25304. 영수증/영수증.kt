fun main(args: Array<String>) {
    var A = readln().toInt()
    var B = readln().toInt()

    var total = 0

    for(temp in (1..B)){
        var(C,D) = readln().split(" ").map { it.toInt() }
        total = C * D + total
    }

    var bool: String = if (total==A) "Yes" else "No"
    println(bool)
}