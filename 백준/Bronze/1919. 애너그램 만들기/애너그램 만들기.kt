import java.lang.StringBuilder
import java.util.*
import kotlin.math.*

fun main() {
    val sc = Scanner(System.`in`)

    val a = sc.nextLine()
    val b = sc.nextLine()

    val countA = IntArray(26)
    val countB = IntArray(26)

    for(i in 0.. a.length-1) {
        countA[a[i].code-'a'.code]++
    }

    for(i in 0..b.length-1) {
        countB[b[i].code-'a'.code]++
    }

    var ans = 0

    for(i in 0 until 26) {
        if(countA[i] > countB[i]) {
            ans += countA[i] - countB[i]
        } else if(countB[i] > countA[i]) {
            ans += countB[i] - countA[i]
        }
    }

    print(ans)
}