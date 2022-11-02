import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val n2 = st.nextToken().toInt()

    var array = Array(n){IntArray(n2)}

    for(temp in 0..1){
      for((index,element) in (1..n).withIndex()){
          val st2 = StringTokenizer(br.readLine())

          for((index2,element2) in (1..n2).withIndex()){
              var a = st2.nextToken().toInt()
              array[index][index2] += a
          }
      }
    }

    for((index,element) in (1..n).withIndex()){

        for((index2,element2) in (1..n2).withIndex()){
            bw.write("${array[index][index2]} ")
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()
    
}