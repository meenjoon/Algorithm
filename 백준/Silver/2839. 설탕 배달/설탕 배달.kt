@file:Suppress("UNREACHABLE_CODE")

import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    
    var n = st.nextToken().toInt()

    var count = 0

    while(true) {
        if(n%5 == 0){
            bw.write("${count + n/5}")
            break
        }
        if(n<=0){
            bw.write("-1")
            break
        }
        n -= 3
        count++
    }

    bw.flush()
    bw.close()
}