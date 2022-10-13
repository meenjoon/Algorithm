import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayList
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var list = arrayListOf<String>()

    var score = 0
    var sum = 0

    for((index, element) in (1..n).withIndex()) {
        var aa = StringTokenizer(br.readLine())
        var bb = aa.nextToken().toString()
        list.add(bb)
    }
    for((index, element) in list.withIndex()){
        sum = 0 //초기화 해줘야함
        score = 0 //초기화 해야줘야함
        for((index2, element2) in element.withIndex()) {
            if(element2 == 'O'){
                score++
                sum +=score
//                println("index:$index2 score:$score sum:$score")
            }
            else{
//                println("index:$index2 score:$score sum:$score")
                score = 0
            }
        }
        println(sum)
    }
}