import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st1 = StringTokenizer(br.readLine()) //콘솔창 첫번째 줄 공백을 기준으로 나눔
    val st2 = StringTokenizer(br.readLine())  //콘솔창 두번째 줄 공백을 기준으로 나눔

    val n = st1.nextToken().toInt() //콘솔창 첫번째 줄의 수열의 갯수
    val x = st1.nextToken().toInt() ////콘솔창 두번째 줄의 주어지는 정수의 수

    for((index, element) in (1..n).withIndex()){ //입력된 n개수 만큼 반복
        var a = st2.nextToken().toInt() //배열이 반복되는 만큼 콘솔창 2번째 줄의 입력값이 추가됨
        if(a<x) {
            bw.write("$a ")
        }
    }
    bw.flush()
}