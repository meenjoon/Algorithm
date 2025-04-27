import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    repeat(n) {
        val num = br.readLine()!!.toInt()

        var result = false
        // 10진법을 2~64 진법까지 반복문을 통해 변환
        for(i in 2..64) {
            val digit = convertBase(num = num, base = i)
            if (isPalindrome(answer = digit)) {
                result = true
                break
            }
        }
        bw.write(if (result) "1\n" else "0\n")
    }

    bw.flush()
    bw.close()
}

/**
 * 진법 변환 함수
 */
fun convertBase(
    num: Int,
    base: Int,
): String {
    var number = num

    var answer = ""
    while (number > 0) {
        val digit = number % base
        if (digit < 10) {
            answer += digit
        } else {
            answer += 'a' - 10 + digit
        }

        number /= base
    }

    return answer.reversed()
}

/**
 * 진법 변환된 String 문자열이 Palindrome(회문)인 지 판별
 */
fun isPalindrome(answer: String): Boolean {
    for(i in 0 until answer.length / 2) {
        if (answer[i] != answer[answer.length - i -1]) {
            return false
        }
    }
    return true
}