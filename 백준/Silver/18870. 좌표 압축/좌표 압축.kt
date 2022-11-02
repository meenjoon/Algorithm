import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val st2 = StringTokenizer(br.readLine())

    var map = mutableMapOf<Int,Int>()

    var nums = IntArray(n)
    var sortNums = IntArray(n)

    var count = 0

    for((index,element) in (1..n).withIndex()){
        var a = st2.nextToken().toInt()

        nums[index] = a //nums 배열에 순서대로 값을 추가
        sortNums[index] = a //sortNums 배열에 순서대로 값을 추가
    }
    sortNums.sort() //sortNums 배열을 오름차순으로 정렬한다.

    for((index,element) in (1..n).withIndex()){ //map 컬렉션에 제일 값은 값부터 큰값까지 0부터 천천히 채워 간다.
        if(map[sortNums[index]] == null) { // map 컬렉션에 sortNums배열의 값(작은값)을 차례로 넣는데 null 이라면
            map[sortNums[index]] = count++
        }
    }

    for((index,element) in (1..n).withIndex()){
        bw.write("${map[nums[index]]} ")
    }

    bw.flush()
    bw.close()

}