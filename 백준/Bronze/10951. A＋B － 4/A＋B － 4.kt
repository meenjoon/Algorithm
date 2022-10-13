import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    try {
        while (true){
            val line = br.readLine()
            if(line == null) {
                break
            }
            else{
                val st = StringTokenizer(line)
                val aa = st.nextToken().toInt()
                val bb = st.nextToken().toInt()
                println("${aa+bb}")
            }
        }

    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }


}