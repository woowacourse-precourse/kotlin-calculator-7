package calculator

fun checkString(input: String?): Boolean {
    /**
     * 문자열 내 숫자 포함 여부를 확인하는 함수
     *
     * @param input 입력 받은 문자열(nullable).
     * @throws IllegalArgumentException 입력 값이 null 이거나 숫자가 포함되어 있지 않으면 예외 발생.
     * @return 문자열에 숫자가 포함되어 있으면 true, 없으면 예외 발생.
     */

    if (input == null) { // 입력값이 null인 경우 예외 발생
        throw throw IllegalArgumentException("ERROR: IllegalArgumentException")
    }

    return if (input.any() { it.isDigit() }) { // 문자열에 숫자가 있는지 검사
        true
    } else {
        throw IllegalArgumentException("ERROR: IllegalArgumentException")
    }
}

// 2. 커스텀 구분자 식별 및 구분자 목록 반환
fun identifyCustomDelimiter(input: String): List<String> {
    /**
     * 커스텀 구분자를 식별하고 구분자 목록을 반환하는 함수
     *
     * @param input 입력받은 문자열(non-null)
     * @return 기본 구분자 리스트에 커스텀 구분자를 추가한 목록
     */

    val defaultDelimiters = listOf(",", ":") // 기본 구분자 리스트
    var delimiters = defaultDelimiters
    val customDelimiterStart = "//" // 커스텀 구분자 식별
    val customDelimiterEnd = "\n"

    if (input.contains(customDelimiterStart)) {
        val delimiterIndex = input.indexOf(customDelimiterStart)
        val customDelimiterIndexStart = delimiterIndex + 2
        val customDelimiterIndexEnd = input.indexOf(customDelimiterEnd, customDelimiterIndexStart)

        if (customDelimiterIndexEnd != -1) { // 커스텀 구분자가 없으면 "-1" 반환, 커스텀 구분자가 있으면 index 반환
            val customDelimiter = input.substring(customDelimiterIndexStart, customDelimiterIndexEnd) // 커스텀 구분자 추출
            delimiters = defaultDelimiters + customDelimiter // 기본 구분자에 커스텀 구분자를 추가
        }
    }

    return delimiters // 구분자 목록 반환
}

fun main() {
    // TODO: 프로그램 구현
    var firstCheck = false // 1. 문자열 검사 결과
    var secondCheck = false // 2. 커스텀 구분자 식별 결과

    // 입력값 요청
    val input = readlnOrNull()

    // 1. 문자열 검사
    if (checkString(input)) {
        firstCheck = true
    }

    // 2. 커스텀 구분자 식별
    if (firstCheck) {
        val delimiters = identifyCustomDelimiter(input!!)
        secondCheck = true
    }
}
// 최종 출력의 형태: "결과 : n"