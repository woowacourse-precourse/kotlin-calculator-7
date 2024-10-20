package calculator

class Validator {
    //역할과 책임에 따라 더 분리해보기
    // 커스텀 구분자의 형식 검증
    fun validateDelimiterFormat(delimiterEndIndex: Int) {
        if (delimiterEndIndex == -1) throw IllegalArgumentException("잘못된 형식입니다.")
    }

    // 커스텀 구분자가 빈 문자열일 경우 예외 발생
    fun validateCustomDelimiter(customDelimiter: String) {
        if (customDelimiter.isEmpty()) throw IllegalArgumentException("잘못된 형식의 구분자입니다.")
    }

    // 숫자로 변환하는 함수, 숫자가 아니면 예외 발생
    fun validateNumber(number: String): Int {
        return number.trim().toIntOrNull()?.takeIf { it >= 0 }  // 숫자로 변환 가능하고 음수가 아닌지 확인
            ?: throw IllegalArgumentException("음수나 숫자가 아닌 값이 포함되어 있습니다.")
    }
}