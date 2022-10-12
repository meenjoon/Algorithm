fun main(args: Array<String>) {
    var (A, B) = readln().split(" ").map { it.toInt() }
    var C = readln().toInt()

    var D = B + C
    var E = D % 60
    var F = D / 60

    if (A + F >= 24 && D >= 60) {
        A = F + A - 24
        B = E
    } else if (D >= 60) {
        A = A + F
        B = E
    } else {
        A = A
        B = D
    }
    println("$A $B")

}