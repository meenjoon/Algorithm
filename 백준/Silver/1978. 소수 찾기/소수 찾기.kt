@file:Suppress("UNREACHABLE_CODE")

import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var st2= StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var count = 0

    var totalcou = 0


    for(temp in 1..n){
        var a = st2.nextToken().toInt()

        for (temp in 2..a){
            if(a%temp == 0){
                count++
            }
        }
        if(count == 1){
            totalcou ++
        }
        count = 0
    }

    bw.write("$totalcou")
    bw.flush()
    bw.close()
}