fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val array = Array(5) { br.readLine()!! }

    val maxLen = array.maxOf { it.length }

    for (i in 0 until maxLen) { // column 기준으로 순회 (세로 방향)
        for (j in 0 until 5) { // row 순회
            if (i < array[j].length) { // 현재 순회 중인 컬럼이 현재 row의 컬럼 사이즈보다 작은 지 체크.
                bw.write(array[j][i].toString())
            }
        }
    }

    bw.flush()
    bw.close()
}
