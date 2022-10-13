import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayList
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var satisfied = 0.0F



    for((index, element) in (1..n).withIndex()) {
        var aa = StringTokenizer(br.readLine())
        var bb = aa.nextToken().toInt()
        var array = FloatArray(bb) // 매 값을 초기화 해줘야 하기 때문에 이 위치에 놓아야함


        for((index2,element2) in (1..bb).withIndex()){
            var cc = aa.nextToken().toInt()
            array[index2] = cc.toFloat()
        }
        satisfied = array.count { it > array.sum() / bb}.toFloat() //평균값을 넘는 학생 수

        bw.write("${String.format("%.3f",satisfied/bb*100)}%\n") //(평균값을 넘는 학생 수 / 전체 학생수) 소수점 셋 째 자리까지 출력
    }
    bw.flush()
    bw.close()
}