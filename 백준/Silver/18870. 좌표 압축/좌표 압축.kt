import java.util.*
import java.io.*
import kotlin.collections.HashMap
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine()!!.toInt()

    // 중복 제거를 위한 Set, TreeSet을 사용했기 때문에 정렬을 하지 않아도 자동으로 오름차순 정렬된 상태로 되게 의도함
    val set = TreeSet<Int>()
    // 원본 배열을 위한 Array
    val array = IntArray(n)
    val inputList = br.readLine()!!.trim().split(" ").map { it.toInt() }
    inputList.forEachIndexed { index, value ->
        set.add(value)
        array[index] = value
    }

    // 중복 제거된 Set을 활용하여 순차적으로 map에 순차적으로 값과 해당하는 인덱스를 할당한다
    val map: MutableMap<Int, Int> = HashMap<Int, Int>()
    var idx = 0
    set.forEach { value ->
        map[value] = idx++
    }

    // map에 중복 제거된 순차적으로 할당된 값들이 할당 되었으니, 원본 배열의 값을 해당 맵에 Key에 넣어 적절한 인덱스 값을 반환하도록 한다.
    for(i in 0 until n) {
        bw.write("${map.getOrDefault(array[i], 0)} ")
    }

    bw.flush()
    bw.close()
}