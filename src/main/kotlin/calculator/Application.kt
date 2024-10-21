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
        throw IllegalArgumentException("ERROR: IllegalArgumentException")
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
    val customDelimiterEnd = "\\n"

    if (input.startsWith(customDelimiterStart)) {
        val customDelimiterIndexStart = customDelimiterStart.length
        val customDelimiterIndexEnd = input.indexOf(customDelimiterEnd)

        if (customDelimiterIndexEnd != -1) { // 커스텀 구분자 찾기
            val customDelimiter = input.substring(customDelimiterIndexStart, customDelimiterIndexEnd)
            delimiters = defaultDelimiters + customDelimiter // 기본 구분자에 커스텀 구분자 추가
        } else {
            throw IllegalArgumentException("ERROR: Custom delimiter format is incorrect")
        }
    }
    return delimiters // 구분자 목록 반환
}

fun extractNumbers(input: String, delimiters: List<String>): List<Int> {
    /**
     * 문자열에서 구분자를 이용하여 숫자들을 분리하고, List(Int)로 반환하는 함수
     *
     * @param input 숫자를 포함한 입력 문자열
     * @param delimiters 문자열을 분리할 구분자들의 리스트
     * @return 입력 문자열에서 구분자를 기준으로 분리된 정수 리스트
     * @throws IllegalArgumentException 음수가 포함된 경우 예외를 발생시킴
     */

    // 커스텀 구분자가 있으면 구분자 이후의 숫자 부분만 추출
    val numbersPart = if (input.startsWith("//")) input.substring(input.indexOf("\\n") + 2) else input

    // 숫자가 하나만 있는 경우 바로 반환
    if (numbersPart.trim().toIntOrNull() != null) {
        return listOf(numbersPart.trim().toInt()) // 숫자 하나일 경우 처리
    }

    // 구분자가 있는 경우 구분자로 숫자 분리
    val extractedNumbers = numbersPart.split(*delimiters.toTypedArray())

    // 숫자 변환 및 필터링
    return extractedNumbers
        .map { it.trim() }  // 공백 제거
        .filter { it.isNotEmpty() } // 빈 문자열 제거
        .map {
            it.toIntOrNull() ?: throw IllegalArgumentException("ERROR: Invalid number format") // 숫자 변환, 실패 시 예외 발생
        }
        .also {
            // 음수 필터링 및 예외 발생
            val negativeNumbers = it.filter { num -> num < 0 }
            if (negativeNumbers.isNotEmpty()) {
                throw IllegalArgumentException("ERROR: Negative numbers are not allowed: $negativeNumbers")
            }
        }
}

// 4. 연산 수행
fun getResult(listOfNumbers: List<Int>): Int {
    /**
     * 분리된 숫자들의 리스트를 받아 연산을 수행함.
     * @param listOfNumbers extractedNumbers 함수의 반환 값
     * @return 정수들의 합
     */
    return listOfNumbers.sum()
}

fun main() {
    // TODO: 프로그램 구현
    var firstCheck = false // 1. 문자열 검사 결과
    var secondCheck = false // 2. 커스텀 구분자 식별 결과

    // 입력값 요청
    val inputValue: String = readlnOrNull() ?: throw IllegalArgumentException("ERROR: Input cannot be null")

    // 1. 문자열 검사
    if (checkString(inputValue)) {
        firstCheck = true
    }

    // 2. 커스텀 구분자 식별
    var identifiedDelimiters: List<String> = listOf() // 구분자 리스트를 선언

    // 커스텀 구분자 식별
    if (firstCheck) {
        identifiedDelimiters = identifyCustomDelimiter(inputValue!!)
        secondCheck = true
    }


    // 3. 숫자 분리
    if (secondCheck) {
        val extractedNumbers = extractNumbers(inputValue, identifiedDelimiters)
        // 4. 연산 수행
        val result = getResult(extractedNumbers)
        println("결과 : $result")
    }
}