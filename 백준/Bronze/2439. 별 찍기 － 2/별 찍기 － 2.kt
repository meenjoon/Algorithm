fun main(args: Array<String>) {
    var A = readln().toInt()

    for((index, element) in (1..A).withIndex()){
        for((index2, element2) in (A-1 downTo element).withIndex()) {
            print(" ")
        }
        for((index2, element2) in (1.. element).withIndex()) {
            print("*")
        }
        println()
    }

}