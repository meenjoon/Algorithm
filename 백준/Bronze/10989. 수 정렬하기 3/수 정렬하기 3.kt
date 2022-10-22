package lv1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()
    
    var array = IntArray(n)

    for(temp in 0 until n){
        var st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toInt()
        array[temp] = a
    }

    array.sort()

    for(temp in 0 until n){
        bw.write("${array[temp]}\n")
    }

    bw.flush()
    bw.close()

}