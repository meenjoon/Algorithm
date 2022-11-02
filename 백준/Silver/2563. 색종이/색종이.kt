import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    val array = Array(100){BooleanArray(100)}
    var answer=0
    while (n--!=0) {
        val st2 = StringTokenizer(br.readLine())
        val a = st2.nextToken().toInt()
        val b = st2.nextToken().toInt()

        for(i in a..a+9 ){
            for(j in b..b+9){
                if(array[i][j]==true){
                    continue
                }
                array[i][j] = true
                answer++
            }
        }
    }

    bw.write("$answer")
    bw.flush()
    bw.close()

}