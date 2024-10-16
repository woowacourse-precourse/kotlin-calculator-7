package calculator

import camp.nextstep.edu.missionutils.Console

/*
* 예상 입력 형식
* 2,2,3:3:5     15
* //;\n1;2;3    6
* 1,2:3;4//;\n  10
* 1,2:3/4///\n  10
* 10,10:10      30
*/
fun main() {
    val str = try {
        Console.readLine().trim()
    } catch (e: IllegalArgumentException) {
        return
    }

    val num = splitString(str)

    // 출력 형식
    println("덧셈할 문자열을 입력해주세요.")
    println(str)
    println(sumNumbers(num))

    Console.close()
}

// 방법1: 문자열을 구분자로 나누는 함수
fun splitString(str: String): List<Int> {
    return if (str.contains("/")) {                 // 커스텀 문자열이 있을 경우
        val index = str.indexOf("//")
        val delimiter = str[index + 2].toString()
        var result = str.removeRange(index, index + 5)
        result.split(",", ":", delimiter).map { it.toInt() }
    } else str.split(",", ":").map { it.toInt() }

}

// 방법2: 문자열에서 숫자만 필터링하는 함수
/*fun filteringString(str: String): List<Int> {
    return str.filter { it.isDigit() }.map { it.toString().toInt() }
}*/

// 숫자의 합을 반환하는 함수
fun sumNumbers(numbers: List<Int>): Int = numbers.sum()