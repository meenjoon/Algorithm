import java.util.*
import kotlin.math.*

fun main() {
    val sc = Scanner(System.`in`)

    val a = sc.nextLine()
    val b = sc.nextLine()

//    val aHour = a.substring(0, 2).toInt() * 3600
//    val aMin = a.substring(3, 5).toInt() * 60
//    val aSec = a.substring(6, 8).toInt()
//
//    val bHour = b.substring(0, 2).toInt() * 3600
//    val bMin = b.substring(3, 5).toInt() * 60
//    val bSec = b.substring(6, 8).toInt()

//    val aTotalSec = aHour + aMin + aSec
//    val bTotalSec = bHour + bMin + bSec

    val aTime = a.split(":")
    val bTime = b.split(":")

    val aTotalSec = aTime[0].toInt() * 3600 + aTime[1].toInt() * 60 + aTime[2].toInt()
    val bTotalSec = bTime[0].toInt() * 3600 + bTime[1].toInt() * 60 + bTime[2].toInt()

    val diffTotalSec = if (bTotalSec <= aTotalSec) {
        bTotalSec - aTotalSec + (3600 * 24)
    } else {
        bTotalSec - aTotalSec
    }

    val diffHour = diffTotalSec / 3600
    val diffMin = (diffTotalSec % 3600) / 60
    val diffSec = diffTotalSec % 60

    val formattedTime = String.format("%02d:%02d:%02d", diffHour, diffMin, diffSec)

    print(formattedTime)
}