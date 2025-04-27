import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    val isEurekaNumbers = isEurekaNumbers(arrangeNum = 1000)

    repeat(n) {
        val requestEurekaNum = br.readLine()!!.toInt()
        if (isEurekaNumbers[requestEurekaNum]) bw.write("1\n") else bw.write("0\n")
    }

    bw.flush()
    bw.close()
}

/**
 * 아래의 함수에는 2중 반복문이 2개가 존재함
 * - 한 개 반복문의 시간 복잡도: eurekaNumCnt^2
 * - 한 개 반복문의 시간 복잡도: arrangeNum * eurekaNumCnt
 * ==> eurekaNumCnt 가 44 정도이고 / arrangeNum이 1000 이기에
 * ==> 현재의 시간 복잡도는 더 큰 시간 복잡도인 arrangeNum * eurekaNumCnt 임.
 * ==> 3중 반복문(eurekaNumCnt^3) / 이중 반복문(arrangeNum * eurekaNumCnt)을 비교하면
 * ==> 3중 반복문(44^3) / 이중 반복문(1000 * 44) 로 큰 차이가 안나긴 하나
 * ==> 만약 eurekaNumCnt 가 44가 아니라 1000이라면 효율은 말도 안되게 차이가 날 것임
 */
fun isEurekaNumbers(
    arrangeNum: Int,
): BooleanArray {
    val isEurekaNums = BooleanArray(arrangeNum + 1)

    // 유레카 넘버 배열 할당
    val triangleNums = IntArray(50)
    var triangleNumCnt = 0
    var index = 1
    while (true) {
        val triangleNumber = index * (index + 1) / 2
        if (triangleNumber >= 1000) break
        triangleNums[triangleNumCnt++] = triangleNumber
        index++
    }

    // 주어진 inputNum이 유레카 넘버 인 지 확인
    val isSumOfTriangleNumbers = BooleanArray(arrangeNum + 1)
    // 2가지 유레카 합을 더해서 더한 값이 arrangeNum 보다 작은 지 여부를 isSumOfNumbers 배열에 저장
    // --> 시간 복잡도: eurekaNumCnt^2
    for(i in 0..triangleNumCnt - 1) {
        for(j in 0..triangleNumCnt - 1) {
            val sum = triangleNums[i] + triangleNums[j]
            if (sum < arrangeNum) {
                isSumOfTriangleNumbers[sum] = true
            }
        }
    }

    // 1부터 입력 받은 자연수의 최댓값인 arrangeNum 까지 반복문을 돌려,
    // 위에서 구한 2가지 유레카 합이 arrangeNum 보다 큰 지 작은지 여부를 가지고 있는 isSumOfNumbers 배열이
    //  - false 일 경우는 continue 통해 넘어감
    //  - true 일 경우는 해당 인덱스와 eurekaNums 배열의 값을 0부터 eurekaNumCnt 까지 반복문을 돌려 나온 값의 합이 arrangeNum보다 작으면 isEurekaNums 배열에 더한값의 인덱스에 true를 할당
    // --> 시간 복잡도: arrangeNum * eurekaNumCnt
    for(i in 1..arrangeNum) {

        if (!isSumOfTriangleNumbers[i]) continue

        for(j in 0..triangleNumCnt - 1) {
            val sum = i + triangleNums[j]
            if(sum <= arrangeNum) {
                isEurekaNums[sum] = true
            }
        }
    }

    return isEurekaNums
}