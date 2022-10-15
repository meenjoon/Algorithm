fun main() {


    var str = readLine().toString()
    var i : Int = 0
    var j : Int = 1
    var result : Int = 10

    var stack = arrayListOf<Char>()

    while(i<str.length) {
        stack.add(str[i])

        if (i > 0) {
            if ((stack[stack.size - 1] == stack[j]) && stack[0] == '(') {
                result += 5
            }

            if ((stack[stack.size - 1] == stack[j]) && stack[0] == ')') {
                result += 5
            }

            else if (stack[j] != stack[stack.size - 1]) {
                result += 10
            }
        }
        i += 1
        j = i - 1

    }
    print(result)
}
