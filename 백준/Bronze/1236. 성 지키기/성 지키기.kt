import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine()!!.trim().split(" ").map { it.toInt() }

    val doubleArray = Array(n) { CharArray(m) }

    repeat(n) {
        doubleArray[it] = br.readLine()!!.toCharArray()
    }

    // 1. 각 행/열에 대해 경비원이 있는지 확인한다.
    var existRowCount = 0
    for(i in 0 until n) {
        var exist = false
        for(j in 0 until m) {
            if (doubleArray[i][j] == 'X') {
                exist = true
                break
            }
        }
        if(exist) existRowCount++
    }

    var existColumnCount = 0
    for(j in 0 until m) {
        var exist = false
        for(i in 0 until n) {
            if (doubleArray[i][j] == 'X') {
                exist = true
                break
            }
        }
        if (exist) existColumnCount++
    }

    // 2. 보호받지 못한 행/열 개수를 구한다.
    val needRowCount = n - existRowCount
    val needColumnCount = m - existColumnCount

    // 3. 둘 중 큰 값을 출력한다.
    bw.write(if (needRowCount > needColumnCount) needRowCount.toString() else needColumnCount.toString())
    bw.flush()
    bw.close()
}