package calculator

class StringCalculator {
    fun add(input: String): Int {
        // 입력이 빈 문자열일 경우 0 반환
        if (input.isEmpty()) return 0

        // 사용자 정의 구분자 처리
        val (delimiter, numbers) = if (input.startsWith("//")) {
            val delimiter = input.substring(2, input.indexOf("\\n")) // 사용자 정의 구분자 추출
            val numbers = input.substringAfter("\\n").split(delimiter) // 구분자에 따라 숫자 분리
            delimiter to numbers
        } else {
            "," to input.split(",", ":") // 기본 구분자 사용
        }

        // 숫자 변환 및 합산, 예외 처리
        return numbers.map {
            val number = it.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력입니다.") // 정수 변환 실패 시 예외 발생
            if (number < 0) throw IllegalArgumentException("음수는 허용되지 않습니다.") // 음수일 경우 예외 발생
            number
        }.sum()
    }
}
