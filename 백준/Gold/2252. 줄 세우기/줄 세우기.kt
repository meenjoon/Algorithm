import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

var n = 0
var m = 0
lateinit var indegree: IntArray
lateinit var adjacencyList: Array<LinkedList<Int>>

fun main() {
    init()
    topologicalSort()
}

fun init() = with(BufferedReader(InputStreamReader(System.`in`))) {
    with(StringTokenizer(readLine())) {
        n = nextToken().toInt()
        m = nextToken().toInt()
    }
    indegree = IntArray(n)
    adjacencyList = Array(n) { LinkedList<Int>() }
    repeat(m) {
        with(StringTokenizer(readLine())) {
            val u = nextToken().toInt() - 1
            val v = nextToken().toInt() - 1
            adjacencyList[u].addLast(v)
            indegree[v]++
        }
    }
    close()
}

fun topologicalSort() = with(BufferedWriter(OutputStreamWriter(System.out))) {
    val queue = LinkedList<Int>()
    for (i in 0 until n) {
        if (indegree[i] == 0) {
            queue.addLast(i)
        }
    }

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        append("${current + 1} ")
        for (next in adjacencyList[current]) {
            indegree[next]--
            if (indegree[next] == 0) {
                queue.addLast(next)
            }
        }
    }
    flush()
    close()
}