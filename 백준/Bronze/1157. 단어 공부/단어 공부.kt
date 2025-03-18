import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val a = sc.nextLine()

    val countArray = getAlphabetCount(str =  a)

    val maxCnt = countArray.maxOrNull()

    var isExistCnt = 0
    var cntIndex = 0
    countArray.forEachIndexed { index, value ->
        if (value == maxCnt) {
            isExistCnt++
            cntIndex = index
        }
    }

    if (isExistCnt > 1) {
        print("?")
    } else {
        print('A' + cntIndex)
    }
}

fun getAlphabetCount(str: String): IntArray {
    val contArray = IntArray(26)

    for(i in 0..str.length-1) {
        if(str[i] >= 'A' && str[i] <= 'Z') {
            contArray[str[i].code-'A'.code]++
        } else {
            contArray[str[i].code-'a'.code]++
        }
    }

    return contArray
}