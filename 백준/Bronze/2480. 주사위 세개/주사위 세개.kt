fun main(args: Array<String>) {
    var (A, B, C) = readln().split(" ").map { it.toInt() }
    var count = 0
    var aa = arrayListOf(A,B,C)

    if(A==B && B==C) {
        count = 10000 + A*1000
    }
    else if(A==B){
        count = 1000 + A*100
    }
    else if(A==C){
        count = 1000 + A*100
    }
    else if(B==C){
        count = 1000 + B*100
    }
    else{
        count = aa.maxOrNull()!! * 100
    }

    println(count)

}