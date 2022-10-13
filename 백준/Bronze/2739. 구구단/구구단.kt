fun main(args: Array<String>) {
    var A = readln().toInt()

    for((index, element) in (A..A).withIndex()) {
        for(temp in (1..9)) {
            println("$element * $temp = ${element * temp}")
        }
    }

}
