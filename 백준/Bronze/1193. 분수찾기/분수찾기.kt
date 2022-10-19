import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()

    var sum = 1
    var temp = 0

    while (temp < n) {
        temp += sum
        sum++
    }
//    println("$temp , $sum")

    if(sum%2 ==0){
        var a = temp - n + 1
        var b = sum - a
        bw.write("$a/$b")
    }
    else {
        var b = temp - n + 1
        var a = sum - b
        bw.write("$a/$b")
    }

    bw.flush()
    bw.close()
}