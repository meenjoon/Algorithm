class Solution {
    /** 참고 링크 : https://taesan94.tistory.com/55

     * 이 문제의 핵심은 패턴을 찾는것이다. 즉, 비어있는 사각형이 어떤 패턴을 가지고 있고, 또 어떤 패턴으로 인해 몇 개의 패턴을 가지고 있는것인지 2개를 찾아야 한다.
     * 여기서는 비어있는 사각형 1개의 패턴은 (w/최대공약수 + h/최대공약수) - 1의 규칙을 가지고 있는데, 꽉차있는 사각형에서 그 중 비어있는 패턴을 새는 규칙이고
     * 이러한 패턴들이 반복하는 횟수는 최대공약수만큼 반복을 한다.
     */
    fun solution(w: Int, h: Int): Long {
        var answer = 0L

        /**
         * 최소 공배수 구하기
         */
        fun gcd(a:Long, b:Long): Long {
            var max = 0L
            var min = 0L
            var remain  = 0L

            if(a>b) {
                max = a
                min = b
            } else {
                max = b
                min = a
            }
            while (min != 0L) {
                remain = max % min
                max = min
                min = remain
            }
            return max
        }

        val gcd = gcd(w.toLong(),h.toLong())

        /**
         * 전체 비어있는 사각형의 개수 구하기 (1개의 패턴에서 가지고 있는 비어있는 사각형 개수 * 패턴 반복 횟수)
         */
        val emptySquare = ((w.toLong()/gcd + h.toLong()/gcd) - 1L) * gcd

        answer = w.toLong() * h.toLong() - emptySquare

        return answer
    }
}