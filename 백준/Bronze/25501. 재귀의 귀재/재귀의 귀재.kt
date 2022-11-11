import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList


var count = 0

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()



    for(temp in 1..n){
        val st2 =StringTokenizer(br.readLine())
        val a = st2.nextToken().toString()

        bw.write("${isPalindrome(a)} $count\n")


    }
    
    bw.flush()
    bw.close()

}
fun recursion(s: String, l: Int, r: Int): Int {
    count += 1
    if(l >= r) return 1
    else if(s[l] != s[r]) return 0
    else return recursion(s, l+1, r-1)
}

fun isPalindrome(s: String): Int {
    count = 0
    return recursion(s, 0, s.length - 1)
}