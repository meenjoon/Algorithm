fun main(args: Array<String>) {

    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    
    fun solution(a: Int, b: Int) {
        for((index, element) in (1..b).withIndex()) {
            for(temp in 1..a){
                print("*")
            }
            println()
        }
    }

    solution(a,b)

}