import java.io.*
fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val set = hashSetOf<String>()
    //겹치지 않도록 hashSet 이용
    val n = readLine().toInt()

    for(i in 0 until n) {
        set.add(readLine())
    }

    set.toMutableList().apply {
        //hashSet은 sortedWith 밖에 호출되지 않기 때문에,
        //sortWith가 가능한 mutableList로 변경.
        sortWith(Comparator { o1, o2 ->
            if (o1.length == o2.length) {
                o1.compareTo(o2)
            } else {
                o1.length - o2.length
            }
        })
        this.forEach {
            bw.write("$it\n")
        }
    }

    bw.flush()
    bw.close()
}