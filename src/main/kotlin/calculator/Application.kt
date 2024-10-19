package calculator

import camp.nextstep.edu.missionutils.Console

fun main() {
    var input: String //입력 문자열
    var result: Int = 0 //결과값

    //입력 문자열 받기
    println("덧셈할 문자열을 입력해 주세요.")
    input = Console.readLine()

    //입력 문자열이 공백이면 결과값은 0
    if (input.isBlank()) {
        print("결과 : 0")
        return
    }

    //입력 문자열이 숫자, 쉼표, 콜론으로 시작하는 경우
    if (input[0].isDigit() || input[0] == ',' || input[0] == ':') {
        val numberParts = input
            .split(",", ":") //기본 구분자인 쉼표(,)와 콜론(:)으로 문자열 분리

        result = numberParts
            .map{ it.toInt() } //분리한 문자열을 정수로 변환
            .sum() //변환한 정수의 합을 계산하여 저장
    }

    //결과 출력
    print("결과 : ${result}")
    return
}
