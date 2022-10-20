import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var notPrime = BooleanArray(100001)
    notPrime[1] = true

    for(temp in 2..10000){
        if(notPrime[temp]) continue

        var j = temp * 2
        while(j<=100000){
            notPrime[j]=true
            j+=temp
        }
    }

    for(temp in 1..n){
        var st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toInt()

        var p = a/2
        var q = a/2
        while(true){
            if(notPrime[p]==false && notPrime[q]==false) {
                bw.write("$p $q \n")
                break
            }
            p--
            q++
        }

    }


    bw.flush()
    bw.close()

}
