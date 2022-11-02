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

    var array = Array(9){IntArray(9)}

    var max = 0
    var low = 0
    var column = 0


    for((index,element) in (1..9).withIndex()){
        val st = StringTokenizer(br.readLine())
        for((index2,element2) in (1..9).withIndex()){
            var a = st.nextToken().toInt()
            array[index][index2] = a
            if(array[index][index2] > max) {
                max = array[index][index2]
                low = index
                column = index2
            }
        }
    }

    bw.write("$max\n")
    bw.write("${low+1} ${column+1}")
    
    bw.flush()
    bw.close()

}