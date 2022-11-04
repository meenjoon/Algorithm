fun main(args: Array<String>) {
    // 입력
    val testCase = readln().toInt()
    val tcList = ArrayList<String>()
    for (i in 1..testCase) {
        tcList.add(readln())
    }
    // 출력
    val sb = StringBuilder()
    tcList.forEach { str -> sb.append(findPalindromeInfo(str)).append("\n") }
    if (sb.isNotEmpty()) {
        sb.setLength(sb.length - 1)
    }
    print(sb.toString())
}

// isPalindrome 과 recursion 함수의 호출 횟수
fun findPalindromeInfo(str: String): String {
    var start = 0
    var end = str.length - 1
    var isPalindrome = 1
    var rCount = 0

    while (start <= end) {
        rCount++
        if (str[start] != str[end]) {
            isPalindrome = 0
            break
        }
        start++
        end--
    }

    // 구조적 차이에 의한 보정
    if (isPalindrome == 1 && str.length % 2 == 0) {
        rCount++
    }

    return "$isPalindrome $rCount"
}