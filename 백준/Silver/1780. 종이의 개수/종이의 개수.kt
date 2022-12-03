import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val matrix = Array(n) {
        val st = StringTokenizer(readLine())
        IntArray(n) { st.nextToken().toInt() }
    }

    val countArray = IntArray(3) // -1, 0, 1을 인덱스 0,1,2로 카운트
    countPapers(matrix, 0, 0, n, countArray)
    val answer = StringBuilder().append(countArray[0]).appendLine()
        .append(countArray[1]).appendLine()
        .append(countArray[2])
    print(answer)
}

// 인자: (행렬, 시작 행, 시작 열, 길이, 카운트 배열)
fun countPapers(matrix: Array<IntArray>, row: Int, col: Int, size: Int, countArray: IntArray) {
    val result = hasSame(matrix, row, col, size) // 같은 숫자만 갖고 있으면 해당 숫자를, 아니면 2를 반환

    // 같은 숫자만 갖고 있으면, 카운트 하고 분할 종료
    if (result != 2) {
        countArray[result + 1]++
        return
    }

    val dividedSize = size / 3
    // 0행 분할
    countPapers(matrix, row, col, dividedSize, countArray) // 0행 0열 (왼쪽 위 행렬)
    countPapers(matrix, row, col + dividedSize, dividedSize, countArray) // 0행 1열 (중앙 위)
    countPapers(matrix, row, col + 2 * dividedSize, dividedSize, countArray) // 0행 2열 (오른쪽 위)

    // 1행
    countPapers(matrix, row + dividedSize, col, dividedSize, countArray)
    countPapers(matrix, row + dividedSize, col + dividedSize, dividedSize, countArray)
    countPapers(matrix, row + dividedSize, col + 2 * dividedSize, dividedSize, countArray)

    // 2행
    countPapers(matrix, row + 2 * dividedSize, col, dividedSize, countArray)
    countPapers(matrix,row + 2 * dividedSize, col + dividedSize, dividedSize, countArray)
    countPapers(matrix, row + 2 * dividedSize, col + 2 * dividedSize, dividedSize, countArray)
}

fun hasSame(matrix: Array<IntArray>, startRow: Int, startCol: Int, size: Int): Int {
    val prevPaper = matrix[startRow][startCol]

    for (row in startRow until startRow + size) {
        for (col in startCol until startCol + size) {
            if (prevPaper != matrix[row][col]) {
                return 2 // 다른 숫자를 갖고 있으면 2를 반환한다
            }
        }
    }

    return prevPaper // 같은 숫자만 갖고 있으면, 해당 숫자 반환
}