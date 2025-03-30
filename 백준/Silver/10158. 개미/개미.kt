import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (w, h) = br.readLine()!!.trim().split(" ").map { it. toInt() }
    var (x, y) = br.readLine()!!.trim().split(" ").map { it. toInt() }
    val t = br.readLine()!!.toInt()

    var directionX = 1
    var directionY = 1

    var repeatW = t % (2 * w)
    while (repeatW-- > 0) {
        if (x == w) {
            directionX = -1
        } else if(x == 0) {
            directionX = 1
        }

        x += directionX
    }

    var repeatH = t % (2 * h)
    while (repeatH-- > 0) {
        if (y == h) {
            directionY = -1
        } else if(y == 0) {
            directionY = 1
        }
        y += directionY
    }

    bw.write("$x $y")
    bw.flush()
    bw.close()
}