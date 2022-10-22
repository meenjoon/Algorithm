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
    var k = st.nextToken().toInt()

    var st2= StringTokenizer(br.readLine())

    var array = IntArray(n)

    for(temp in 0..n-1){

        var a = st2.nextToken().toInt()
        array[temp] = a
    }
    array.sortDescending()

    bw.write("${array[k-1]}")
    bw.flush()
    bw.close()

}