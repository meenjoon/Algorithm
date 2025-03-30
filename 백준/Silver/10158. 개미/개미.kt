import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (w, h) = br.readLine()!!.trim().split(" ").map { it. toInt() }
    var (x, y) = br.readLine()!!.trim().split(" ").map { it. toInt() }
    val t = br.readLine()!!.toInt()

//    var directionX = 1
//    var directionY = 1
//
//    var repeatW = t % (2 * w)
//    while (repeatW-- > 0) {
//        // 경계면 끝에 도달 한다면
//        if (x == w) {
//            directionX = -1
//        }
//        // 경계면 처음에 도달 한다면
//        else if(x == 0) {
//            directionX = 1
//        }
//
//        x += directionX
//    }
//
//    var repeatH = t % (2 * h)
//    while (repeatH-- > 0) {
//        // 경계면 끝에 도달 한다면
//        if (y == h) {
//            directionY = -1
//        }
//        // 경계면 처음에 도달 한다면
//        else if(y == 0) {
//            directionY = 1
//        }
//        y += directionY
//    }

    // 기존에는 x에서 출발해 T시간 후 위치를 구함.
    // --> 0에서 출발을 맞춰 놓은 후 위치를 구한다면?
    // --> (x + T) 시간 후 일 것이다.
    // --> 여기서 중요한 것은 P는 분명 x좌표 값인데, 우리는 이것을 좌우로 왔다 갔다 하는 것으로 놓고 풀기에 시간으로 놓고 푸는 것이다!!!
    // 추가로 경계를 만나기 전 / 후 를 구분지어야 한다
    // --> 경계를 만나기 전: currentX <= W
    // --> 경계를 만난 후: 2W - currentX (W 이후 방향 전환 차이만큼 W로부터 멀어진 것을 의미)

    // 즉, 쉽게 말을 한다면,
    // 0 에서 출발하는 것을 가정하기 위해 (x + t)를 해줌
    // 증가, 감소 방향이 w(너비)를 기준으로 바뀌기에 (2 * w)를 해줌
    // 그렇게 해서 x의 좌표가 방향 전환(증가, 감소 방향)인 지를 구별해야하는 값(2 * w)을 추출함
    // 그렇게 증가, 감소 방향인 지를 모르는 값을 증가, 감소 방향인 지를 판별하기 위해
    // --> 해당 값이 w(너비) 보다 크다면 방향 전환(감소 방향) 이기에 2배의 너비(2 * w)에서 현재의 x를 빼주면 진짜로 얼마만큼 떨어졌는지의 최종 x 좌표를 구할 수 있다!!
    // 위의 것을 y 좌표도 따로 구해준다면, 답을 구할 수 있다.
    x = (x + t) % (2 * w)
    y = (y + t) % (2 * h)

    if(x > w) {
        x = (2 * w) - x
    }
    if (y > h) {
        y = (2 * h) - y
    }

    bw.write("$x $y")
    bw.flush()
    bw.close()
}