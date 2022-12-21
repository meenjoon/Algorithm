import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val s = Stack<Int>()

    var num = 0

    
    for(temp in 1..n){
        val st2 = StringTokenizer(br.readLine())
        val a = st2.nextToken().toInt()

        if(a != 0) {
            s.push(a)
        }
        else {
            s.pop()
        }
    }
    var array = IntArray(s.size)

    array = s.toIntArray()

    for (temp in array) {
        num += temp
    }
    bw.write("$num")
    bw.flush()
    bw.close()
}
