import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader( InputStreamReader(System.`in`) )
    var st: StringTokenizer
    var sb = StringBuilder()

    st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()
    var list : MutableList<Int> = ArrayList()
    list.add(0, 0)

    st = StringTokenizer(br.readLine())
    for(i in 1..N) {
        list.add(list.get(i - 1) + Integer.parseInt(st.nextToken()))
    }

    for(i in 0 until M) {
        st = StringTokenizer(br.readLine())
        var num = st.nextToken().toInt()
        var num2 = st.nextToken().toInt()

        sb.append(list.get(num2) - list.get(num - 1)).append('\n')
    }

    print(sb)
} // End of main