import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val a = sc.nextLine()
    val b = sc.nextLine()

    var count = 0
    var i = 0
    while(i <= a.length -1) {
        var isMatch = true
        for(j in 0..b.length-1) {
            if(i+j >= a.length || a[i+j] != b[j]) {
                isMatch = false
                break
            }
        }

        if(isMatch) {
            count++
            i += b.length
        } else {
            i++
        }
    }

    print(count)
}