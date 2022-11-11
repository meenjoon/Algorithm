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

    var fib = 0

    val array = IntArray(n+2)

    array[0] = 0
    array[1] = 1


    if(n>=3) {
        for (temp in 1..n - 1) {
            array[temp + 1] = array[temp - 1] + array[temp]
            fib = array[temp + 1]
        }
    }
    else if(n==2 || n== 1){
        fib = 1
    }
    else if (n==0){
        fib = 0
    }

    bw.write("$fib")
    bw.flush()
    bw.close()
}