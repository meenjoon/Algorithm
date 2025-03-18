import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val a = sc.nextLine()

    val countArray = getAlphabetCount(str =  a)

    var maxCnt = -1
    var resultChar = '?'
    countArray.forEachIndexed { index, value ->
        // value는 해당 알파벳의 중복 개수, index는 'A' 혹은 'a'가 0 인 위치 값으로 부터 몇 번째 떨어졌는지
        if (value > maxCnt) {
            maxCnt = value
            resultChar = 'A' + index
        } else if(value == maxCnt) {
            resultChar = '?'
        }
    }

    print(resultChar)
}

fun getAlphabetCount(str: String): IntArray {
    val contArray = IntArray(26)

    for(i in 0..str.length-1) {
        if(str[i] in 'A'..'Z') {
            contArray[str[i].code-'A'.code]++
        } else {
            contArray[str[i].code-'a'.code]++
        }
    }

    return contArray
}