import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val a = sc.nextLine()

    var result = ""
    a.forEach {
        val asciiCode = it.code
        result += if (asciiCode in 65..90) {
            // 대문자 -> 소문자
            (it + 32)
        } else if (asciiCode in 97..122) {
            // 소문자 -> 대문자
            (it - 32)
        } else {
            // 알파벳 아닐 경우 그대로
            it
        }
    }

    println(result)
}
