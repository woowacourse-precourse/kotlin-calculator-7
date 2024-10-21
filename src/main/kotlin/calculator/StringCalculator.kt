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

        // 분리된 숫자를 정수로 변환하고 합산
        return numbers.map { it.toInt() }.sum()
    }
}
