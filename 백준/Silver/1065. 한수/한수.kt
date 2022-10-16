import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayList
import java.util.StringTokenizer
import kotlin.math.abs

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()

    var count = 0

    if(n>=100) { //n이 100 이상 일 경우

        for (temp in 1..9) {
            count++
        }
        for (temp in 10..99) {
            count++
        }
        for ((index, element) in (100..n).withIndex()) {
            var hundred = element / 100
            var ten = (element % 100) / 10
            var one = element % 10

            if (one - ten == ten - hundred) {
                count++
            }
        }
    }
    else if(n>=10){ //n이 10 이상 일 경우
        for(temp in 10..n){
            count++
        }
        for(temp in 1..9){
            count++
        }
    }
    else if(n>0){ //n이 1 이상 일 경우
        for(temp in 1..n){
            count++
        }
    }
        bw.write("$count")
        bw.flush()
        bw.close()
}