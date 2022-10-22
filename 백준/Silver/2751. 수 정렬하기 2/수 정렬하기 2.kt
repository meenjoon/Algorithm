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

    var list = mutableListOf<Int>()

    for(temp in 1..n){
        var st2 = StringTokenizer(br.readLine())
        var n = st2.nextToken().toInt()
        list.add(n)
    }

    var listsort = list.sorted()

    for((index, element) in (1..n).withIndex()){
        var a = listsort[index]
        bw.write("$a\n")
    }

    bw.flush()
    bw.close()

}