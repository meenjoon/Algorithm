class Solution {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer: Int = 1234567890
        var array = arrayOfNulls<Int>(a.size)
        var aa = 0


        for((indexa, elementa) in a.withIndex()) {
            aa += a[indexa] * b[indexa]
        }

        return aa
    }
}