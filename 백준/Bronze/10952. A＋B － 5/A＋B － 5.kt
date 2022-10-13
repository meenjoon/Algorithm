import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    for((index, element) in (1..100000).withIndex()){ //입력된 n개수 만큼 반복
        var aa = StringTokenizer(br.readLine())
        var bb = aa.nextToken().toInt()
        var cc = aa.nextToken().toInt()

        if(bb == 0 && cc == 0){
            break
        }
        else{
            bw.write("${bb+cc}\n")
        }
    }
    bw.flush()
}