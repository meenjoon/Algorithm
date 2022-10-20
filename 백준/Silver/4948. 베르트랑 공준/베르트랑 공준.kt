import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true){
        var st = StringTokenizer(br.readLine())
        var n = st.nextToken().toInt()

        var notPrime = BooleanArray(246913) //초기화
        notPrime[1] = true //초기화
        var min = n + 1
        var max = n * 2 //초기화
        var count = 0 //초기화

        if(n==0){
            break
        }
        else {
            for (temp in 2..max){
                if(notPrime[temp]) continue
                var j = temp *2
                while (j<=max) {
                    notPrime[j] = true
                    j +=temp
                }
            }

            for(temp in min..max){
                if(!notPrime[temp]){
                    count++
                }
            }
        }
        bw.write("$count\n")
    }

    bw.flush()
    bw.close()

}
