package calculator
import camp.nextstep.edu.missionutils.Console

// 기본 구분자에 대한 숫자 합산하는 함수
fun defaultSum(input: String?): Int {

    if (input.isNullOrEmpty()) {
        return 0
    }
    val sep1= input.split(",",":")   // 기본 구분자를 기준으로 분리
    return sep1.sumOf { it.toInt() }
}

// 커스텀 구분자에 대한 숫자 합산하는 함수
fun customSum(input: String): Int {

    val part = input.split("\\n")   // \n 기준으로 두 파트로 분리
    val delimiter = part[0][2]  // 구분자 추출
    val sep2 = part[1].split(delimiter)  // 커스텀 구분자를 기준으로 분리

    return sep2.sumOf { it.toInt() }
}

fun main() {

    val input = Console.readLine()
    val result: Int
    // 기본 구분자와 커스텀 구분자의 경우 분리
    if (input.startsWith("//")) {
        result = customSum(input)
    } else {
        result = defaultSum(input)
    }
    println("결과 : $result")
}


