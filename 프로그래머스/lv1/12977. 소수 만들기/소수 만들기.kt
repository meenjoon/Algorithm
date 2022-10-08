class Solution {
    fun solution(nums: IntArray): Int {
        var answer = -1
        var list = mutableListOf<Int>()
        var count = 0

        for (i in 0..nums.size - 3) {
            for (j in i + 1..nums.size - 2) {
                for (k in j + 1..nums.size - 1) {
                    list.add(nums[i] + nums[j] + nums[k])
                    if(isPrime(nums[i] + nums[j] + nums[k]) == true){
                        count++
                    }
                }
            }
        }

        answer = count

        return answer
    }

        fun isPrime(n: Int): Boolean {
            var i = 2
            while(i * i <= n){
                if(n % i++ == 0) {
                    return false
                }
            }
            return true
        }
}