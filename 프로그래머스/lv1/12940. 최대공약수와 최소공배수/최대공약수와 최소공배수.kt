class Solution {
    fun solution(n: Int, m: Int): IntArray {
        
        var nn = n
        var mm = m

        var num = 0

        var greatest_common  = 0
        var least_common = 0

        if(nn>mm){
            while (mm!=0){
                num = nn % mm
                nn = mm
                mm = num
            }
            greatest_common = nn
        }
        else{
            while (nn!=0){
                num = mm % nn
                mm = nn
                nn = num
            }
            greatest_common = mm
        }

        least_common = (n * m) / greatest_common


        return intArrayOf(greatest_common,least_common)
    }
}