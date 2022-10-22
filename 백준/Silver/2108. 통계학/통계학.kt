
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer
import kotlin.math.round

fun main(args: Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var array = IntArray(n)
    var map = mutableMapOf<Int,Int>()

    var average:Double = 0.0

    var center = 0

    var countmax = 0

    var minst = 0
    var maxst = 0
    var diff = 0


    for (temp in 0..n-1){
        var st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken().toInt()
        if(!map.containsKey(a)){
            map.put(a,1)
        }
        else {
            map[a] = map.getValue(a)+1
        }

        array[temp] = a


    }
    array.sort()
    map = map.toSortedMap()

    var mapcountmax = map.maxByOrNull { it.value }!!

    for((index, element) in (map.filter { (key, value) -> value == mapcountmax.value }.keys).withIndex()){
        if(((map.filter { (key, value) -> value == mapcountmax.value }.keys).size)==1){
            countmax=element
        }
        else {
            if (index == 1) {
                countmax = element
            }
        }
    }

    for(temp in 0..n-1){
        average+=array[temp]

    }



    if(n==1){
        average = array[0].toDouble()
        center = array[0]

    }
    else{
        average = round(average/n)


        for((index,element) in array.withIndex()){
            if(index ==array.size / 2 ){
                center = element
//                println("$index, $element")
            }
        }



//        var set = array.toMutableSet().sorted()
//        var setcenter = set.size/2
//
//        if(set.size % 2 ==1) {
//            for ((index, elemet) in set.withIndex()) {
//                if (index == setcenter) {
//                    center = elemet
//
//                }
//
//
//            }
//        }
//        else{
//            for ((index, elemet) in set.withIndex()) {
//                if (index == setcenter) {
//                    center = elemet
//
//                }
//
//            }
//        }

    }

    minst = array.minOrNull()!!
    maxst = array.maxOrNull()!!
    diff = maxst-minst

    bw.write("${average.toInt()}\n$center\n$countmax\n$diff")
    bw.flush()
    bw.close()

}