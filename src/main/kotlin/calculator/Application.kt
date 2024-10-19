package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var input: String //입력 문자열
    var result: Int = 0 //결과값

    //입력 문자열 받기
    input = readInput()

    //입력 문자열이 공백이면 결과값은 0
    if (input.isBlank()) {
        showResult(0)
    }

    //입력 문자열이 '//'로 시작하는 경우
    if (input.startsWith("//")) {
        val parts = input.split("\\n") //커스텀 구분자 파트와 숫자 파트로 분리

        //'\n'이 없는 경우 IllegalArgumentException 발생, 애플리케이션 종료
        if (parts.size != 2) {
            throw IllegalArgumentException()
        }

        val delimiter = parts[0].substring(2) //커스텀 구분자

        //커스텀 구분자가 없는 경우 IllegalArgumentException 발생, 애플리케이션 종료
        if (delimiter.isEmpty()) {
            throw IllegalArgumentException()
        }

        //숫자가 없는 경우 결과값은 0
        if (parts[1].isEmpty()) {
            showResult(0)
        }

        val numberParts = splitByDelimiter(parts[1], delimiter)

        result = numberParts
            .map { it.toInt() } //분리한 문자열을 정수로 변환
            .sum() //변환한 정수의 합을 계산하여 저장
    }
    //입력 문자열이 숫자, 쉼표, 콜론으로 시작하는 경우
    else if (input[0].isDigit() || input[0] == ',' || input[0] == ':') {
        val numberParts = splitByDelimiter(input)

        result = numberParts
            .map{ it.toInt() } //분리한 문자열을 정수로 변환
            .sum() //변환한 정수의 합을 계산하여 저장
    }
    //잘못된 값을 입력한 경우 IllegalArgumentException 발생, 애플리케이션 종료
    else {
        throw IllegalArgumentException()
    }

    //결과 출력
    showResult(result)
}

/* 구분자 기준 문자열 분리 함수 */
fun splitByDelimiter(input: String, customDelimiter: String? = null): List<String> {
    //커스텀 구분자가 있으면 추가하고, 없으면 기본 구분자만 사용
    val delimiters =
        if (customDelimiter != null)
            arrayOf(",", ":", customDelimiter)
        else
            arrayOf(",", ":")

    //구분자 기준으로 문자열 분리
    val numbers = input.split(*delimiters)

    return numbers
}

/* 문자열 입력 함수 */
fun readInput(): String {
    println("덧셈할 문자열을 입력해 주세요.")
    return Console.readLine()
}

/* 결과 출력 함수 */
fun showResult(result: Int) {
    print("결과 : ${result}")
    return
}