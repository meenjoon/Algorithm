import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

val br = System.`in`.bufferedReader()
//1<=n<=10000
//1<=m<=10000
val set = HashSet<String>()

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    var answer=0
    for(i in 0 until n){
        set.add(br.readLine())
    }
    for(i in 0 until m){
        if(set.contains(br.readLine()))
            answer++
    }

    write("$answer")
    close()
}