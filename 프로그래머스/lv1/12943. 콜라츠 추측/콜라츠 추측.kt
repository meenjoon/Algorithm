class Solution {
    fun solution(num: Int): Int = collatz(num.toLong(), 0)


    fun collatz(num: Long, count: Int): Int {
        if (count > 499) return -1
        else if (num == 1L) return count
        else if (num % 2L == 0L) return collatz(num / 2, count + 1)
        else if (num % 2L != 0L) return collatz(num * 3 + 1L, count + 1)
        else return 0
    }

}