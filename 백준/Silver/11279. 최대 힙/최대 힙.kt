import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Math.pow
import java.lang.NumberFormatException
import java.util.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt
 
 
val br = BufferedReader(InputStreamReader(System.`in`))
 
fun main()=with(br){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine()!!.toInt()
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    for(i in 0 until n){
        val a = readLine()!!.toInt()
        if(a==0){
            if(!maxHeap.isEmpty()){
                bw.write("${maxHeap.poll()}\n")
            }
            else
                bw.write("0\n")
        }
        else{
            maxHeap.add(a)
        }
    }
    bw.flush()
    bw.close()
}