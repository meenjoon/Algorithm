import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st1 = StringTokenizer(br.readLine())
    var s = st1.nextToken().toInt()
    var list = mutableListOf<Char>()

    for((index, element) in (1..s).withIndex()){
        list.clear()
        
        var aa = StringTokenizer(br.readLine())
        var a = aa.nextToken().toInt()
        var b = aa.nextToken()

        for((index1, element2) in b.withIndex()){
            for(temp in 1..a){
                list.add(element2)
            }
        }
        var answer = list.joinToString("")
        bw.write("$answer\n")
        bw.flush()
    }
    bw.close()
}