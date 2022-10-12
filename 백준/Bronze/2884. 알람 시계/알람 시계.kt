fun main(args: Array<String>){
    var (A,B) = readln().split(" ").map { it.toInt() }

    if (A==0 && B<45) {
        B = 60+B-45
        A = 23
    }
    else if(B<45) {
        B = 60+B-45
        A -= 1
    }
    else {
        B = B - 45
    }

    println("$A $B")

}