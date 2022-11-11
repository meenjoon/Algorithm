import java.io.*
import java.util.StringTokenizer

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {


    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    for(y in 0 until n){
        for(x in 0 until n){
            Star(x, y, n)
        }
        bw.write("\n")
    }
    bw.flush()
    bw.close()

}

fun Star(x: Int, y: Int, N: Int) {
    if((x/N) % 3 == 1 && (y/N)%3 == 1) {
        bw.write(" ")
    }
    else if(N/3==0){
        bw.write("*")
    }
    else {
        Star(x,y,N/3)
    }
}