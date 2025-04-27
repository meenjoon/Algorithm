import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    val array = Array(n) { CharArray(n) }
    repeat(n) {
        val charArray = br.readLine()!!.trim().toCharArray()
        array[it] = charArray
    }

    // 문제의 흐름
    // 1. 가능한 모든 쌍의 사탕을 서로 교환해본다.
    // 2. 교환한 상태에서 가장 긴 연속 부분 행/열을 찾는다.
    // 3. 교환한 사탕을 원복한다.

    var ans = 0

    /**
     * 시간 복잡도
     *  - N^2[모든 사탕에 대한 반복문] * [ (2N^2[가능한 모든 쌍의 사탕 교환]) + (2N^2[교환한 상태에서의 가장 긴 연속 부분 행/ 열 찾기]) ]
     * ==> O(N^4)
     */
    for(i in 0 until n) {
        for(j in 0 until n) {
            // 여기서 오른쪽 방향과 아래 방향으로만 생각해도 되는 이유가,
            // 이렇게 하더라도 결국 가능한 모든 쌍의 사탕을 교환하기 때문이다!!!

            // 오른쪽 방향
            if(j + 1 < n && array[i][j] != array[i][j + 1]) {
                // 캔디를 오른쪽 방향으로 교환
                swapCandy(array, i, j, i, j + 1)
                // 교환 후 최대 Column Row 방향으로 각각 연결된 사탕의 최대 갯수 중 최댓값을 구한다.
                ans = max(ans, max(findMaxColumn(array), findMaxRow(array)))
                // 교환된 캔디 원복
                swapCandy(array, i, j, i, j + 1)
            }
            // 아래 방향
            if(i + 1 < n && array[i][j] != array[i + 1][j]) {
                // 캔디를 아래 방향으로 교환
                swapCandy(array, i, j, i + 1, j)
                // 교환 후 최대 Column Row 방향으로 각각 연결된 사탕의 최대 갯수 중 최댓값을 구한다.
                ans = max(ans, max(findMaxColumn(array), findMaxRow(array)))
                // 교환된 캔디 원복
                swapCandy(array, i, j, i + 1, j)
            }
        }
    }

    bw.write("$ans")

    bw.flush()
    bw.close()
}

fun swapCandy(
    array: Array<CharArray>,
    r1: Int,
    c1: Int,
    r2: Int,
    c2: Int,
) {
    val tempValue = array[r1][c1]
    array[r1][c1] = array[r2][c2]
    array[r2][c2] = tempValue
}

fun findMaxRow(array: Array<CharArray>): Int {
    var maxRow = 0

    for(r in 0 until array.size) {
        var currentColor = array[r][0]
        var length = 0
        for(c in 0 until array.size) {
            if (array[r][c] == currentColor) {
                length++
            } else {
                currentColor = array[r][c]
                length = 1
            }
            maxRow = max(maxRow, length)
        }
    }

    return maxRow
}

fun findMaxColumn(array: Array<CharArray>): Int {
    var maxColumn = 0

    for(c in 0 until array.size) {
        var length = 0
        var currentColor = array[0][c]
        for(r in 0 until array.size) {
            if (array[r][c] == currentColor) {
                length++
            } else {
                currentColor = array[r][c]
                length = 1
            }

            maxColumn = max(maxColumn, length)
        }
    }

    return maxColumn
}