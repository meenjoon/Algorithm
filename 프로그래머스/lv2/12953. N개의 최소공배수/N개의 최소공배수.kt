class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0

        val sortList = arr.toList().sortedDescending() //최대공약수를 구하기 위해서 큰 수부터 작은수로 정렬을 해준다.
        //주의해야 할 점은 array에서는 sort밖에 안되기에 sortDescending을 하기 위해선 List로 바꿔준 후 SortDescending을 사용해준드ㅏ.

        var lcd = 0 //최소공배수
        var gcd = 0 //최대공약수

        for ((index, value) in sortList.withIndex()) {

            if(index==0) { //index가 0일 경우
                gcd = gcd(value, sortList[index+1]) //최대공약수 구하기
                lcd = value * sortList[index+1] / gcd //최소공배수 구하기 (최소공배수 : (a*b)/최대공약수)
            }

            else if(!(index==sortList.size-1)){ //index가 1부터 마지막 인덱스 까지

                gcd = gcd(lcd, sortList[index+1]) //최대공약수 구하기
                lcd = lcd * sortList[index+1] / gcd //최소공배수 구하기 (최소공배수 : (a*b)/최대공약수)
            }
        }
        answer = lcd
        return answer
    }
    //}

    fun gcd(maxNum:Int, secondNum:Int): Int { //최대공약수 구하기(최소공배수를 구하기 위해서이다. 최소공배수:(a*b)/최대공약수 )

        var a = maxNum
        var b = secondNum
        var n : Int
        while (b!=0) { //b가 0일 경우 while문 종료 (b는 a(큰 수)에서 b를 나눈 나머지이다.)
            n = a % b
            a = b
            b = n
        }
        return a

    }
}