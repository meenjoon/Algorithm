@file:Suppress("UNREACHABLE_CODE")

import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var st2= StringTokenizer(br.readLine())

    var a = st.nextToken().toInt()
    var b = st2.nextToken().toInt()

    var count = 0
    var total = 0

    var list = mutableListOf<Int>()

    for(temp in a..b){
        for(temp2 in 2..temp){
            if(temp % temp2 == 0){
                count++
            }
        }
        if(count==1){
            total += temp
            list.add(temp)
        }
        count=0
    }
    var min = list.minByOrNull { it }

    if(total==0 || list == null){
        bw.write("-1")
    }
    else {
        bw.write("$total\n$min")
    }

    bw.flush()
    bw.close()
}