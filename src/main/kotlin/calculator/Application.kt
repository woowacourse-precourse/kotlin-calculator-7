package calculator

import camp.nextstep.edu.missionutils.Console


fun main() {
    // TODO: 프로그램 구현
    // 문자열 입력받기
    println("덧셈할 문자열을 입력해 주세요.")
    val input = Console.readLine()

}
// 커스텀 구분자 사용 여부 확인 함수
fun isCustomDelimiter(input: String): Boolean {
    return input.startsWith("//")
}

// 유효한 커스텀 구분자를 추출하고 지정하는 함수
fun extractCustomDelimiter(input: String): Pair<String, String> {
    // "\n"이 있는 지 확인
    if (input[3] == '\\' && input[4] == 'n') {
        // 구분자를 추출
        val delimiter = input.substring(2, 3)
        val numbersPart = input.substring(5)  // 숫자 부분 추출

        // 숫자 제외 모든 문자 가능 여부 확인
        val isValidDelimiter = delimiter.all { it !in '0'..'9' }

        // 구분자가 유효한 경우
        if (isValidDelimiter) {
            return Pair(delimiter, numbersPart)
        } else {
            throw IllegalArgumentException("유효한 구분자가 아닙니다.")
        }
    }
    throw IllegalArgumentException("유효한 커스텀 구분자가 없습니다.")
}
