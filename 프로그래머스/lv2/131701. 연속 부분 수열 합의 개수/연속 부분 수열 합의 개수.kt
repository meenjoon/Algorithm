class Solution {
    fun solution(elements: IntArray): Int {
        
        var answer: Int = 0

        val array = IntArray(elements.size*2){ 0 }
        
        val set = mutableSetOf<Int>()

        for(index in 0 until array.size) {
            array[index] = elements[index % elements.size]
        }
        array.forEach { print(it) }

        for(i in 1 until elements.size+1 ) {
            for(j in 0 until elements.size) {
                set.add(array.copyOfRange(j,j+i).sum())
            }
        }

        answer = set.size
        
        return answer
    }
}