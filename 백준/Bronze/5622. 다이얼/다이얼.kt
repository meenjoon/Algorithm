import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken()

    var list = mutableListOf<Int>()

    var total = 0

    for(temp in n){
        if(temp in 'A'..'C'){
            list.add(3)
        }
        else if(temp in 'D'..'F'){
            list.add(4)
        }
        else if(temp in 'G'..'I'){
            list.add(5)
        }
        else if(temp in 'J'..'L'){
            list.add(6)
        }
        else if(temp in 'M'..'O'){
            list.add(7)
        }
        else if(temp in 'P'..'S'){
            list.add(8)
        }
        else if(temp in 'T'..'V'){
            list.add(9)
        }
        else if(temp in 'W'..'Z'){
            list.add(10)
        }
        else{
            list.add(11)
        }
    }

    total = list.sumOf { it }

    bw.write("$total")
    bw.flush()
    bw.close()
}