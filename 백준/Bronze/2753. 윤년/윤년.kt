fun main(args: Array<String>){
    val A = readln().toInt()

    val B = if ( A % 4 == 0 && (A%100 != 0 || A%400 == 0)) 1 else 0

    println(B)

}