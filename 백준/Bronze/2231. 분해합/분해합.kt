import java.util.*
 
fun checkSum(x:Int): Boolean {
    for (i in 1..x){
        var array = IntArray(7) { 0 }
        var _x = i
        var j = 0
        while(_x != 0){
            array[j] = (_x % 10)
            _x /= 10
            j++
        }
        val sum = array.sum()
        if(i+sum == x){
            println(i)
            return true
        }
    }
    return false
}
 
fun main(){
    val sc: Scanner = Scanner(System.`in`)
    val N = sc.nextInt()
    if (!checkSum(N)){
        println("0")
    }
}