import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var n = 0
private lateinit var arr : Array<IntArray>
private var blueCnt = 0
private var whiteCnt = 0
fun main() {
    val br = System.`in`.bufferedReader()
    n = br.readLine().toInt()
    arr = Array(n){ IntArray(n){ 0 } }
    repeat(n){
        arr[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    slice(0,0,n)
    println(whiteCnt)
    println(blueCnt)
}
private fun slice(x:Int, y:Int,d:Int){
    if(d == 1 || !canSlice(x,y,d)){ // 길이가 1이거나 자를 수 있지 않을 때
        countColor(arr[x][y])
    }
    else {
        slice(x=x, y=y, d=d/2)
        slice(x=x+(d/2), y=y, d=d/2)
        slice(x=x, y=y+(d/2), d=d/2)
        slice(x=x+d/2, y=y+d/2, d=d/2)
    }
}
private fun canSlice(x:Int, y:Int,d:Int) : Boolean{
    for(i in x until x+d){
        for(j in y until y+d){
            if(arr[x][y] != arr[i][j])
                return true
        }
    }
    return false
}
private fun countColor(color:Int){
    if(color == 1)
        blueCnt += 1
    else
        whiteCnt += 1
}