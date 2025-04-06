import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    val array = br.readLine()!!.trim().split(" ").map {
        it.toInt()
    }.toTypedArray()

    val x = br.readLine()!!.toInt()

    // input으로 들어온 수에 대해, 해당하는 인덱스에 true로 할당하는 BooelanArray 정의
    val exist = BooleanArray(1000001).also { booleanArray ->
        array.forEach {
            booleanArray[it] = true
        }
    }

    var cnt = 0
    for(i in 0 until n) {
        val pairValue = x - array[i]
        if(0 <= pairValue && pairValue <= 1000000) {
            // x가 8일 때 가정을 하고, 동일한 수(4+4)와 같은 경우에도 cnt++를 해도 괜찮은 이유가 어차피 나누기 2를 하면 x가 짝수든 홀수든 처리가 가능하기 때문
            cnt += if(exist[pairValue]) 1 else 0
        }
    }

    bw.write("${cnt/2}")
    bw.flush()
    bw.close()
}