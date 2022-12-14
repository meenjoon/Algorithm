import java.io.*
import java.util.*
 
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
 
var n = 0
var m = 0
val check = BooleanArray(10, { false })
 
fun printString(sequence: String) {
    for (i in 0..sequence.length - 1) {
        bw.write("${sequence[i]} ")
    }
    bw.write("\n")
}
 
fun dfs(sequence: String) {
    if (sequence.length >= m) {
        printString(sequence)
        return
    }
    for (i in 1..n) {
        if (check[i]) continue
        check[i] = true
        dfs(sequence + "$i")
        check[i] = false
    }
}
 
fun main() {
 
    val token = StringTokenizer(br.readLine(), " ")
    n = token.nextToken().toInt()
    m = token.nextToken().toInt()
 
    dfs("")
 
    bw.flush()
}