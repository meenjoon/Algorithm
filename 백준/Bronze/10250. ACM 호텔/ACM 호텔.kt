import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()
    
    for(temp in 1..n){
        var ho = 0
        var floor = 0

        var st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toInt()
        var b = st2.nextToken().toInt()
        var c = st2.nextToken().toInt()

        if(c%a == 0){
            floor = a
            ho = c/a
        }
        else {
            floor = c % a
            ho = c / a + 1
        }
        
        if(ho<10) {
            bw.write("${floor.toString()}0${ho.toString()}\n")
        }
        else {
            bw.write("${floor.toString()}${ho.toString()}\n")
        }
    }

    bw.flush()
    bw.close()
}