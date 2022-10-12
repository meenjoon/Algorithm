fun main(args: Array<String>){
    val (A,B) = readln().split(" ").map { it.toInt() }

    if(A>B) {
        println(">")
    }
    else if (A<B) {
        println("<")
    }
    else {
        println("==")
    }
    
}