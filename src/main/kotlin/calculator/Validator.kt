package calculator

class Validator {
    //역할과 책임에 따라 더 분리해보기
    fun validate(input: String): Int {
        // 빈 문자열이 입력된 경우 0을 반환
        if (input.isBlank()) return 0

        // 커스텀 구분자가 있는지 확인 (문자열이 "//"로 시작하고 "\n"으로 구분되는 경우)
        val (numbers, delimiters) = if (input.startsWith("//")) {
            // 커스텀 구분자 처리
            val delimiterEndIndex = input.indexOf("\n") //없을 경우 어떻게 되는지?
            if (delimiterEndIndex == -1) throw IllegalArgumentException("잘못된 형식입니다.")

            // 커스텀 구분자 추출
            val customDelimiter = input.substring(2, delimiterEndIndex)
            if (customDelimiter.isEmpty()) throw IllegalArgumentException("잘못된 형식의 구분자입니다.")

            // 커스텀 구분자를 기준으로 나머지 숫자 부분을 추출
            val numberPart = input.substring(delimiterEndIndex + 1)
            Pair(numberPart, customDelimiter)
        } else {
            // 기본 구분자 처리
            Pair(input, "[,:]") // 쉼표와 콜론을 기본 구분자로 지정 (정규식으로 사용)
        }

        // 숫자들을 분리하고 합산
        return splitAndSum(numbers, delimiters)
    }

    // 숫자를 구분자로 분리하고 합을 구하는 함수
    fun splitAndSum(numbers: String, delimiter: String): Int {
        return numbers
            .split(Regex(delimiter))  // 구분자로 숫자 분리
            .map { toIntOrThrow(it) }  // 각각을 Int로 변환 (유효하지 않으면 예외 발생)
            .sum()  // 합산
    }

    // 숫자로 변환하는 함수, 숫자가 아니면 예외 발생
    fun toIntOrThrow(number: String): Int {
        return number.trim().toIntOrNull()?.takeIf { it >= 0 }  // 숫자로 변환 가능하고 음수가 아닌지 확인
            ?: throw IllegalArgumentException("음수나 숫자가 아닌 값이 포함되어 있습니다.")
    }
}