class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var right_loaction = 12 // 오른손 위치 #을 12으로 생각해서 12
        var left_location =  10 // 왼손 위치 *을 10으로 생각해서 10
        for (number in numbers){
            if (number == 1 || number == 4 || number == 7){
                left_location = number
                answer += "L"
            } else if (number == 3 || number == 6 || number == 9){
                right_loaction = number
                answer += "R"
            }
            else{
                var location = number // 숫자 패드 
                if (number == 0) location = 11  // 0인경우 11로 두어야 3나눈 몫이랑 나머지 연산 사용가능

                if(dis(left_location, location) < dis(right_loaction, location)) { //왼쪽이 더 작음
                    left_location = location
                    answer += "L"
                }
                else if(dis(left_location, location) > dis(right_loaction, location)){ //오른쪽 더 작음
                    right_loaction = location
                    answer += "R"
                }else{
                    if(hand == "right"){
                        right_loaction = location
                        answer += "R"
                    }
                    else{
                        left_location = location
                        answer+="L"
                    }
                }
            }
        }
        return answer
    }



    fun dis(number : Int, now_hand : Int) : Int{
        return (Math.abs(number - now_hand)) % 3  +  (Math.abs(number - now_hand)) / 3 
    }
}