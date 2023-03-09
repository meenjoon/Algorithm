class Solution {
fun solution(name: String): Int {
        var answer = 0

        /**
         * 이것은 좌우로 움직이는 횟수를 담아놓는 변수 move이다. 처음에는 왼쪽부터 오른쪽까지 쭉 가는 횟수인 name.length-1의 횟수로 초기화한다.
         */
        var move = name.length-1

        /**
         * name의 길이만큼 반복을 한다.
         */
        for(index in 0 until name.length) {

            /** 좌, 우 구하기 로직 변수
             *
             */
            var next = index + 1 //다음 인덱스의 문자열이 'A'인지 찾기 위한 변수이다.

            /** 좌, 우 구하기 로직
             * next의 인덱스가 name의 범위 안에 들어있으면서 name[next]의 값이 'A'라면
             * next값을 +1씩 해준다. 그러다가 또 다시
             * next의 인덱스가 name의 범위 안에 들어있으면서 name[next]의 값이 'A'라면
             * next값을 +1씩 해준다.
             * while문이 종료되면, name String 배열의 현재 인덱스의 next값이 나올텐데 이 의미는,
             * 지금 인덱스의 값으로부터 가장 가까운 'A'를 찾는데 이어진 경우(BBFAAD라면 AA가 이어지는데 앞의 A가 아니라 AA까지 횟수를 측정)에도 +1씩 해준다는 의미다.
             */
            while (next<name.length && name[next] == 'A') {
                next++
            }
            /** 좌, 우 구하기 로직
             * 좌우 이동간의 최소 횟수를 구하기 위한 move 함수이다.
             * 기존의 move변수의 값과 2*index+name.length-next을 비교하는데,
             * 순서대로 가는 것(왼쪽에서 오른쪽으로 가는것과) 뒤로 돌아 가는 것(오른쪽에서 왼쪽으로 가는것) 중에서 최솟값을 선택하는 것이다.
             * 여기서 2*index+name.length-next의 값의 의미는
             * 2 * index의 의미는 중간까지 왔다가 다시 뒤로 갈때의 조이스틱 이동횟수이며,
             * name.length-next의 의미는 오른쪽에서 A가 아닌 값들을 나타낸다.
             *
             */
            move = Math.min(move, 2*index+name.length-next) //오른쪽으로 갔다 다시 왼쪽으로 리턴하는 경우
            move = Math.min(move, index + (name.length-next) * 2 ) //왼쪽으로 갔다 다시 리턴하여 오른쪽으로 가는 경우
            /** 상,하 구하기 로직
             * 만약 name의 현재 인덱스의 값이 'A'가 아닌 값이라면 우리는 상, 하를 움직여서 원하는 값을 맞춰야한다.
             * temp라는 변수는 현재 인덱스 값의 위치를 알려주는 변수다.
             * 왜냐하면 'A'의 아스키 값은 65이기 때문에 만약 'C'의 값이 아스키 코드로 67인데 'C'.toInt() - 65 = 2 가 나올 것 이다.
             * 그렇기에 -65를 해주어 현재 위치를 찾는다.
             * 조건으로는 반으로 뚝 짤라서 13의 위치보다 크다면,
             * 오른쪽에서 왼쪽으로 접근하는게 더 최소값이기 때문에 26-temp를 해주었다.참고(알파벳의 개수는 26개이다. 그러니 전체 개수(마지막 위치)-(현재 위치)를 하게되면 뒤에서부터 접근 할 수 있다.)
             */
            if(name[index]!='A') {
                var temp = name[index].toInt() - 65
                if(temp >=13) {
                    temp = 26-temp
                }
                /**
                 * answer에 temp의 값을 더해준다.
                 */
                answer +=temp

                /** 아래의 방법도 가능하다.
                var temp = name[index] - 'A'

                if(temp>=13) {
                   temp = 26 - temp
                }
                answer += temp
                 */
            }
        }
        /**
         * 최종적으로 나온 move의 값을 for문이 끝나면 answer에 더해준다.
         */
        answer +=move

        println(answer)
        return answer
    }
}