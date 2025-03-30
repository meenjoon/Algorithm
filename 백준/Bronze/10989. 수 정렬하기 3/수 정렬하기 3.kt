import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    // 해당 숫자가 몇 개 있는지를 담기 위한 배열
    val cnt = IntArray(10001)

    // 시간 복잡도 O(max(10000, N))
    repeat(n) {
        cnt[br.readLine()!!.toInt()]++
    }

    // 시간 복잡도 O(max(10000, N))
    // --> 기본적으로 for의 반복문이 10000번 돌고, 그 외에 while 반복문이 돌기에 이 둘 중 더 큰 값으로 O(N) 시간 복잡도가 되게 된다.
    for (i in 1 until 10001) {
        // 해당 숫자가 여러 개 라면 0이 될 때까지 출력
        while(cnt[i]-- > 0) {
            bw.write("$i\n")
        }
    }

    bw.flush()
    bw.close()
}