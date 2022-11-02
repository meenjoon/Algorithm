import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    var arraylist = ArrayList<Pair<Int,String>>()
    
    for(temp in 1..n){
        val st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toInt()
        var b = st2.nextToken().toString()

        arraylist.add(Pair(a,b))
    }

    arraylist.sortWith(compareBy({it.first}))

    for((index,temp) in (1..n).withIndex()) {
        bw.write("${arraylist[index].first} ${arraylist[index].second}\n")
    }

    bw.flush()
    bw.close()

}