import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    var (n, b) = br.readLine()!!.trim().split(" ").map {
        it.toInt()
    }

    var answer = ""
    if (n == 0 ) {
        answer = "0"
    } else {
        while (n > 0) {
            val digit = n % b

            if (digit < 10) {
                answer += digit
            } else {
                answer += 'A' + digit - 10
            }
            n /= b
        }
    }
    
    bw.write(answer.reversed())

    bw.flush()
    bw.close()
}