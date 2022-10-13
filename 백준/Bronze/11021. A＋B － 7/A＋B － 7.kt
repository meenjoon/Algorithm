fun main(args: Array<String>) {
    var A = readln().toInt()

    for(temp in 1..A){
        var (B,C) = readln().split(" ").map { it.toInt() }
        println("Case #$temp: ${B+C}")
    }
}