//참고 : https://minhamina.tistory.com/58
class Solution {
    fun solution(n: Int): IntArray {
        var answer = IntArray(n*(n+1)/2)

        val matrix = Array(n) {IntArray(n)}



        var x = -1
        var y = 0

        var num = 1

        for(index in 0 until n) {
            for(index2 in index until n) {
//                println("[$index][$index2] ")
                if (index % 3 == 0) {
                    x++
                } else if(index % 3 == 1) {
                    y++
                } else if(index % 3 == 2) {
                    x--
                    y--
                }
                matrix[x][y] = num++
            }
        }

        var k = 0

        for(index in 0 until n) {
            for(index2 in 0 until n) {
//                print("[$index][$index2]:${matrix[index][index2]} ")
                if(matrix[index][index2] == 0) {
                    break
                }
                answer[k++] = matrix[index][index2]
            }
        }

//        answer.forEach { print(it) }


        return answer
    }
}