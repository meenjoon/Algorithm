class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        var list = arr.toList()
        var min = arr[0]


        for (i in 0 until arr.size){
            if(min > arr[i]){
                min = arr[i]
            }
        }
        if(arr.count()==1){
            answer += -1
        }
        else {
            for (num in arr) {
                if (num > min) {
                    answer += num
                }
            }
            
        }
        return answer
    }
}