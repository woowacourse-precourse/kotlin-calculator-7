package calculator

class StringCalculator {
    fun add(input: String): Int {
        // 입력이 빈 문자열일 경우 0 반환
        if (input.isEmpty()) return 0

        // 쉼표(,)와 콜론(:)을 기본 구분자로 사용하여 숫자를 분리하고 합산
        return input.split(",", ":").map { it.toInt() }.sum()
    }
}
