import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayList
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var list = mutableListOf<Int>()

    for(temp in 1..10000){
        if(temp >= 1000) { //4자리 경우의수
            val thousand = temp / 1000
            val hundred = (temp % 1000) /100
            val ten = (temp % 100) / 10
            val one = temp % 10
            list.add(temp + thousand + hundred + ten + one)
        }
        else if( temp >= 100 ){ //3자리 경우의 수
            val hundred = temp / 100
            val ten = (temp % 100)  / 10
            val one = temp % 10
            list.add(temp + hundred + ten + one)

        }
        else if( temp >= 10) { //2자리 경우의 수
            val ten = temp / 10
            val one = temp % 10
            list.add(temp + ten + one)
        }
        else { //1자리 경우의 수
            list.add(temp + temp)
        }
    }

    for(temp in 1..10000) {
        if(!list.contains(temp)){ //1~10000의 리스트 값 중 없는 것을 추출 즉, 셀프 넘버
            println(temp)
        }
    }
}