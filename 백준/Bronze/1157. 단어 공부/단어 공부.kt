import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st1 = StringTokenizer(br.readLine())
    var s = st1.nextToken()

    var ss = s.uppercase()

    var map = mutableMapOf<Char,Int>()

    var max = 0
    var maxCount = 0

    for((index, element) in ss.withIndex()){
        if(map.containsKey(element)) {
            map[element] = map[element]!!.plus(1)
        }
        else{
            map.put(element, 1)
        }
    }

    max = map.maxOfOrNull { it.value }!!
    maxCount= map.count { it.value == max }

    if(maxCount>1) {
        print("?")
    }
    else{
        bw.write(map.filter { it -> it.value==max }.keys.joinToString())
    }
    bw.flush()
    bw.close()
}