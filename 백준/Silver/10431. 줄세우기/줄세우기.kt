import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    repeat(n) {
        val intArray = br.readLine()!!.trim().split(" ").filterIndexed { index, s ->
           index != 0
        }.map { it.toInt() }.toIntArray()

        // 새로 정렬할 Array
        val sortedArray = IntArray(20)

        var cnt = 0
        for (i in 0 until 20) {
            // 1. 줄 서 있는 학생 중에 자신보다 큰 학생을 찾는다.
            //   1-1. 찾지 못했다면, 줄의 가장 뒤에 선다.
            var find = false
            for(j in 0 until i) {
                if (sortedArray[j] > intArray[i]) {
                    // 2. 찾았다면, 그 학생의 앞에 선다.
                    // 3. 그 학생과 그 뒤의 학생이 모두 한칸 씩 물러난다.
                    find = true
                    // 가장 앞에 자신보다 큰 학생 인덱스인 j를 찾았다면, j 다음 인덱스부터 i 인덱스까지 값이 물러나야한다.(값들이 한칸 씩 밀려남)
                    for(k in i downTo j+1) {
                        sortedArray[k] = sortedArray[k-1]
                        cnt++
                    }
                    sortedArray[j] = intArray[i]
                    break
                }
            }
            // 찾지 못했다면, 줄의 가장 뒤에 선다.
            if (!find) sortedArray[i] = intArray[i]
        }

        bw.write("${it + 1} $cnt\n")
    }

    bw.flush()
    bw.close()
}