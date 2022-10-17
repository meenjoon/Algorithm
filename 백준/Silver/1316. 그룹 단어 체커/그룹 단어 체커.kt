import java.io.*
import java.util.*

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()

    var total = n

    for(temp in 1..n) {
        var st2 = StringTokenizer(br.readLine())
        var a = st2.nextToken()

        var set = mutableSetOf<Char>() //초기화
        var lastChar = ' ' // 확인 할 글자
        var groupWord = true // boolean을 통해 그룹 단어인지 아닌지 확인

        for((index,element) in a.withIndex()){ //입력한 글자를 하나하나 뜯어보기
            if(lastChar != element) { //글자 하나하나 lastChar 변수를 통해 비교를 하는데 마지막으로 확인한 글자와 다음 글자가 서로 다를 경우
                lastChar = element // lastChar(확인할 글자)를 한 글자로 초기화
                if(!set.add(element)) { //처음 안 사실인데 set은 중복이 불가능하기 때문에, 즉, set 컬렉션에 이미 글자가 있다면 add가 안되기 때문에 이것을 if로 확인할 수 있다는 것이다. 그러니까 set 컬렉션에 추가가 안될때(이미 같은 글자가 set컬렉션에 있을때) 
                    groupWord = false //그룹 단어가 아니다.
                }
            }
        }
        if(groupWord==false){ //for문 바로 다음에 실행되기 때문에 단어의 개수만큼 total 변수에 영향이 감
            total--
        }
    }

    bw.write("$total")
    bw.flush()
    bw.close()
}