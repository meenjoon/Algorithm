import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*


object Main {
    lateinit var A: IntArray
    lateinit var tmp: IntArray
    
    var count = 0
    var result = -1
    var K = 0
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        val N = st.nextToken().toInt()
        K = st.nextToken().toInt()
        st = StringTokenizer(br.readLine())
        A = IntArray(N)
        for (i in 0 until N) {
            A[i] = st.nextToken().toInt()
        }
        tmp = IntArray(N)
        merge_sort(A, 0, N - 1)
        println(result)
    }

    fun merge_sort(A: IntArray, p: Int, r: Int) {
        if (count > K) return
        if (p < r) {
            val q = (p + r) / 2
            merge_sort(A, p, q)
            merge_sort(A, q + 1, r)
            merge(A, p, q, r)
        }
    }

    fun merge(A: IntArray, p: Int, q: Int, r: Int) {
        var i = p
        var j = q + 1
        var t = 0
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t] = A[i]
                i++
            } else {
                tmp[t] = A[j]
                j++
            }
            t++
        }
        while (i <= q) tmp[t++] = A[i++]
        while (j <= r) tmp[t++] = A[j++]
        i = p
        t = 0
        while (i <= r) {
            count++
            if (count == K) {
                result = tmp[t]
                break
            }
            A[i++] = tmp[t++]
        }
    }
}

