import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
 
 
 
val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
 
fun main()=with(br){
    var (a,b,c) = readLine()!!.split(" ").map{it.toLong()}
    var ans = pow(a,b,c)
    bw.write("$ans")
    bw.flush()
    bw.close()
}
 
fun pow(base:Long,expo:Long,mod:Long): Long {
    if(expo==1L)
        return base%mod
 
    var temp = pow(base,expo/2,mod)
 
    if(expo%2==0L){
        return (temp*temp)%mod
    }
    return ((temp*temp)%mod*base)%mod
}